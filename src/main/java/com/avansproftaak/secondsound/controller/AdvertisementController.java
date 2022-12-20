package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.model.SavedAdvertisement;
import com.avansproftaak.secondsound.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(path = "advertisement/saved/get")
    public List<SavedAdvertisement> AddAdvertisement() {
        return advertisementService.getSavedAdvertisements();
    }

    @PostMapping(path = "advertisement/saved/post")
    public boolean saveAdvertisement(@RequestBody Long advertisementId) {
        return advertisementService.savedAdvertisementHandler(advertisementId);
    }
}
