package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.controller.UserController;
import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.ResourceRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserService userService;
    private final ResourceRepository resourceRepository;
    private final ModelMapper modelMapper;

    public List<AdvertisementDto> getAllAdvertisements() {

        var adList = advertisementRepository.findAll();
        ArrayList<AdvertisementDto> adListDto = new ArrayList<>();

        for (Advertisement advertisement : adList) {
            var advertisementDto = new AdvertisementDto(
                    advertisement.getId(),
            advertisement.getTitle(),
            advertisement.getDescription(),
            advertisement.getPrice(),
            resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
            advertisement.getUser().getId());

            adListDto.add(advertisementDto);
        }
        return adListDto;

    }

    public AdvertisementDto addAdvertisement(AdvertisementData advertisement) throws ParseException {



        var currencyPrice = BigDecimalParser.parse(advertisement.getPrice());
        User user = userService.getAuthenticatedUser();
        Advertisement newAdvertisement = new Advertisement(advertisement.getTitle(), advertisement.getDescription(), currencyPrice, user);
        advertisementRepository.save(newAdvertisement);
        return getAdvertisement(newAdvertisement);
    }

    public AdvertisementDto getAdvertisement(Advertisement advertisement) {

        return new AdvertisementDto(
            advertisement.getId(),
            advertisement.getTitle(),
            advertisement.getDescription(),
            advertisement.getPrice(),
            resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
            advertisement.getUser().getId()
        );
    }

    public UserDto getSeller(User user) {
        return modelMapper.map(user, UserDto.class);
    }

}
