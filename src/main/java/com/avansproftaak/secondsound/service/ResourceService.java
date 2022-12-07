package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.ImgBBRes;
import com.avansproftaak.secondsound.model.Resource;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.ResourceRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResourceService {
    private final static String BASE_URL = "https://api.imgbb.com/1/upload?key=a6046a56f8b4c887f33b44d99cb0d7a0";
    private final AdvertisementRepository advertisementRepository;
    private final ResourceRepository resourceRepository;

    public ResourceService(AdvertisementRepository advertisementRepository, ResourceRepository resourceRepository) {
        this.advertisementRepository = advertisementRepository;
        this.resourceRepository = resourceRepository;
    }

    public void imageString(String imageString) {

    }

    public String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Please select a file to upload.");
        }

        MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("image", Base64.getEncoder().encode(file.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ImgBBRes> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, requestEntity, ImgBBRes.class);

        return Objects.requireNonNull(response.getBody()).getData().getDisplay_url();
    }

    public ResponseEntity<String> uploadAdvertisementImage(Long advertisementId, MultipartFile file, User user) throws IOException {
        Optional<Advertisement> advertisementOptional = advertisementRepository.findById(advertisementId);

        if (advertisementOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement does not exist.");
        }

        Advertisement advertisement = advertisementOptional.get();
        if (advertisement.getUser() != user) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "User has no permission to upload images for this advertisement");
        }

        String imageUrl;

        if (file == null) {
            imageUrl = "https://rejse-glæde.dk/wp-content/themes/klikko3_b_2022_08_05/dest/images/no-image.webp";
        } else {
            imageUrl = uploadImage(file);
        }

        Resource resource = new Resource();
        resource.setFilePath(imageUrl);
        resource.setAdvertisement(advertisement);
        resourceRepository.save(resource);

        return new ResponseEntity<>("File successfully uploaded", HttpStatus.OK);
    }
}
