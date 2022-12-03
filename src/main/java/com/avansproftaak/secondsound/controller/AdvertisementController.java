package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/v1.0/")
public class AdvertisementController {

    private final AdvertisementService advertisementService;
    private final UserService userService;

    @Autowired
    public AdvertisementController(AdvertisementService advertisementService, UserService userService) {
        this.advertisementService = advertisementService;
        this.userService = userService;
    }

    @GetMapping(path="public/advertisement")
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @PostMapping(path = "advertisement")
    public AdvertisementDto AddAdvertisement(@RequestBody Advertisement advertisement) {
        System.out.println("test");
        return advertisementService.addAdvertisement(advertisement);
    }

}
