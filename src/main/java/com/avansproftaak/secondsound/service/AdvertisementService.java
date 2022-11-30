package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.ResourceRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final ResourceRepository resourceRepository;


    public AdvertisementService (AdvertisementRepository advertisementRepository, ResourceRepository resourceRepository) {
        this.advertisementRepository = advertisementRepository;
        this.resourceRepository = resourceRepository;
    }


    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();

    }
}
