package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
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

@Service
@AllArgsConstructor
public class AdvertisementService {


    private final UserService userService;
    private final AdvertisementRepository advertisementRepository;
    private final ResourceRepository resourceRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ModelMapper modelMapper;

    public List<AdvertisementDto> getAllAdvertisements() {

        var adList = advertisementRepository.findAll();
        ArrayList<AdvertisementDto> adListDto = new ArrayList<>();

        for (Advertisement advertisement : adList) {

            var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));

            var seller = userService.getSeller(advertisement.getUser().getId());

            var advertisementDto = new AdvertisementDto(
                    advertisement.getId(),
                    advertisement.getTitle(),
                    advertisement.getDescription(),
                    advertisement.getPrice(),
                    resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                    subcategory,
                    seller);

            adListDto.add(advertisementDto);
        }
        return adListDto;

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
        var seller = userService.getSeller(advertisement.getUser().getId());

        System.out.println(seller.getLastName());

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
}
