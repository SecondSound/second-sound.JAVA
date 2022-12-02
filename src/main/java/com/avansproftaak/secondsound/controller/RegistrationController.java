package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.RegistrationDto;
import com.avansproftaak.secondsound.dto.ResponseDto;
import com.avansproftaak.secondsound.dto.TokenDto;
import com.avansproftaak.secondsound.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1.0/auth/register")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public TokenDto register(@RequestBody RegistrationDto request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public ResponseDto confirm(@RequestParam("token") UUID token) {
        return registrationService.confirmToken(token);
    }
}
