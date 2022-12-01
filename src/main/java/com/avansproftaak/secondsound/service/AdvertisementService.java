package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.controller.UserController;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.ResourceRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();

    }

    public AdvertisementDto addAdvertisement(Advertisement advertisement) {

        User user = userService.getAuthenticatedUser();

        Advertisement newAdvertisement = new Advertisement(advertisement.getTitle(), advertisement.getDescription(), advertisement.getPrice(), user);
        advertisementRepository.save(newAdvertisement);

        return getAdvertisement(newAdvertisement);
    }

    public AdvertisementDto getAdvertisement(Advertisement advertisement) {

        return new AdvertisementDto(advertisement.getId(), advertisement.getTitle(), advertisement.getDescription(), advertisement.getPrice(), advertisement.getUser().getId());
    }
}
