package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path="api/v1.0/")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping(path="public/advertisement")
    public List<AdvertisementDto> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping(path="public/advertisement/{id}")
    public AdvertisementDto getAdvertisement(@PathVariable Long id) {
        return advertisementService.getFullAdvertisement(id);
    }


    @PostMapping(path = "advertisement")
    public AdvertisementDto AddAdvertisement(@RequestBody AdvertisementData advertisementData) {
        return advertisementService.addAdvertisement(advertisementData);
    }

}
