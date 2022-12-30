package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.SavedAdvertisement;
import com.avansproftaak.secondsound.model.SubCategory;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.*;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisementService {


    private final UserService userService;
    private final AdvertisementRepository advertisementRepository;
    private final ResourceRepository resourceRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final SavedAdvertisementRepository savedAdvertisementRepository;
    private final ModelMapper modelMapper;

    public List<AdvertisementDto> getAllAdvertisementsPublic() {

        var adList = advertisementRepository.findAll();
        ArrayList<AdvertisementDto> adListDto = new ArrayList<>();

        for (Advertisement advertisement : adList) {
            var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));
            var seller = userService.getSellerOrBidder(advertisement.getUser().getId());

            var advertisementDto = new AdvertisementDto(
                    advertisement.getId(),
                    advertisement.getTitle(),
                    advertisement.getDescription(),
                    advertisement.getPrice(),
                    resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                    subcategory,
                    seller,
                    false);

            adListDto.add(advertisementDto);
        }
        return adListDto;
    }

    public List<AdvertisementDto> getAllAdvertisementsAuth() {
        var adList = advertisementRepository.findAll();

        return mapAdvertisementDto(adList);
    }

    public boolean isSaved(User user, Advertisement advertisement) {

        return savedAdvertisementRepository.existsByUserAndAdvertisement(user, advertisement);
    }

    public AdvertisementDto addAdvertisement(AdvertisementData advertisement) {

        var currencyPrice = BigDecimalParser.parse(advertisement.getPrice());
        User user = userService.getAuthenticatedUser();
        SubCategory subCategory = subCategoryRepository.findById(advertisement.getSubCategoryId().longValue())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));

        Advertisement newAdvertisement = new Advertisement(advertisement.getTitle(), advertisement.getDescription(), currencyPrice, subCategory, user, advertisement.isActive());

        advertisementRepository.save(newAdvertisement);
        return getAdvertisement(newAdvertisement);
    }

    public AdvertisementDto getAdvertisement(Advertisement advertisement) {

        var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategory unknown"));
        var seller = userService.getSellerOrBidder(advertisement.getUser().getId());

        return new AdvertisementDto(
                advertisement.getId(),
                advertisement.getTitle(),
                advertisement.getDescription(),
                advertisement.getPrice(),
                resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                subcategory,
                seller);
    }

    public UserDto getSeller(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public AdvertisementDto getFullAdvertisement(Long id) {
        var advertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));

        return getAdvertisement(advertisement);
    }

    public List<AdvertisementDto> getSavedAdvertisements() {

        User user = userService.getAuthenticatedUser();
        var savedAdList = new ArrayList<AdvertisementDto>();

        if (savedAdvertisementRepository.existsByUser(user)) {
            var savedList = savedAdvertisementRepository.findAllByUser(user);

            for (SavedAdvertisement savedAd : savedList) {
                var advertisement = this.advertisementRepository.findById(savedAd.getAdvertisement().getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement not found"));

                var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SubCategory unknown"));
                var seller = userService.getSellerOrBidder(advertisement.getUser().getId());

                savedAdList.add(new AdvertisementDto(
                        advertisement.getId(),
                        advertisement.getTitle(),
                        advertisement.getDescription(),
                        advertisement.getPrice(),
                        resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                        subcategory,
                        seller,
                        isSaved(user, advertisement))
                );
            }
            return savedAdList;
        } else {
            return null;
        }
    }

    public boolean savedAdvertisementHandler(Long advertisementId){
        User user = userService.getAuthenticatedUser();
        Advertisement advertisement = advertisementRepository.findById(advertisementId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement not found"));

        var exists = savedAdvertisementRepository.existsByUserAndAdvertisement(user, advertisement);
        System.out.println("exists: " + exists);

        if (!exists) {
            return addSavedAdvertisement(advertisement, user);
        } else {
            return deleteSavedAdvertisement(advertisement, user);
        }
    }

    public boolean addSavedAdvertisement(Advertisement advertisement, User user) {
            var savedAdvertisement = new SavedAdvertisement();
            savedAdvertisement.setAdvertisement(advertisement);
            savedAdvertisement.setUser(user);
            savedAdvertisementRepository.save(savedAdvertisement);
            return true;
    }

    public boolean deleteSavedAdvertisement(Advertisement advertisement, User user) {
        var savedAdvertisement = savedAdvertisementRepository.getSavedAdvertisement(user.getId(), advertisement.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Saved advertisement not found"));

        savedAdvertisementRepository.deleteById(savedAdvertisement.getId());
        return false;
    }

    public List<AdvertisementDto> getAllAdvertisementsUser() {
        User user = userService.getAuthenticatedUser();

        List<Advertisement> userAdvertisements = advertisementRepository.findAllByUser(user);

        return mapAdvertisementDto(userAdvertisements);
    }

    private List<AdvertisementDto> mapAdvertisementDto(List<Advertisement> adList) {
        ArrayList<AdvertisementDto> adListDto = new ArrayList<>();

        for (Advertisement advertisement : adList) {
            var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));
            var seller = userService.getSellerOrBidder(advertisement.getUser().getId());

            var advertisementDto = new AdvertisementDto(
                    advertisement.getId(),
                    advertisement.getTitle(),
                    advertisement.getDescription(),
                    advertisement.getPrice(),
                    resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                    subcategory,
                    seller,
                    false);

            adListDto.add(advertisementDto);
        }

        return adListDto;
    }
}
