package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        var x = advertisementService.getAllAdvertisements();
        return x;
    }

    @PostMapping(path = "advertisement")
    public AdvertisementDto AddAdvertisement(@RequestBody AdvertisementDto advertisementDto) {
        return advertisementService.addAdvertisement(advertisementDto);
    }

}
