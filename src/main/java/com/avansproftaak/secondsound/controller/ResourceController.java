package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.ResourceService;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path="api/v1.0/resource")
public class ResourceController {

    private final UserService userService;
    private final ResourceService resourceService;

    @Autowired
    public ResourceController(UserService userService, ResourceService resourceService) {
        this.userService = userService;
        this.resourceService = resourceService;
    }

    @PostMapping("/advertisement/{id}")
    public ResponseEntity<String> uploadAdvertisementResource(
            @PathVariable("id") Long id,
            @RequestParam("file") @Nullable MultipartFile file
    ) throws IOException {

        User user = userService.getAuthenticatedUser();
        return resourceService.uploadAdvertisementImage(id, file, user);
    }
}
