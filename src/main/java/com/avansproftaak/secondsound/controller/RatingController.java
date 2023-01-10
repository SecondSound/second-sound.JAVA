package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.RatingDto;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.RatingService;
import com.avansproftaak.secondsound.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1.0/rating")
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;
    private final UserService userService;

    @GetMapping
    public List<RatingDto> getUserRatings() {
        User user = userService.getAuthenticatedUser();
        return this.ratingService.getUserRatings(user);
    }
}
