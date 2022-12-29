package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.SellerDto;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ArrayList<AdvertisementDto> getAllAdvertisementsPublic() {
        return advertisementService.getAllAdvertisementsPublic();
    }

    @GetMapping(path="advertisement")
    public ArrayList<AdvertisementDto> getAllAdvertisementsAuth() {
        return advertisementService.getAllAdvertisementsAuth();
    }

    @GetMapping(path="public/advertisement/{id}")
    public AdvertisementDto getAdvertisement(@PathVariable Long id) {
        return advertisementService.getFullAdvertisement(id);
    }

    @PostMapping(path = "advertisement")
    public AdvertisementDto AddAdvertisement(@RequestBody AdvertisementData advertisementData) {
        return advertisementService.addAdvertisement(advertisementData);
    }

    @GetMapping(path = "advertisement/saved")
    public List<AdvertisementDto> AddAdvertisement() {
        return advertisementService.getSavedAdvertisements();
    }

    @PostMapping(path = "advertisement/saved")
    public boolean saveAdvertisement(@RequestBody Long advertisementId) {
        return advertisementService.savedAdvertisementHandler(advertisementId);
    }

    @GetMapping(path = "public/advertisement/seller/{id}")
    public SellerDto getSeller(@PathVariable Long id) {
        return userService.getSellerOrBidder(id);
    }

}
