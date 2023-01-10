package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.RatingDto;
import com.avansproftaak.secondsound.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1.0/rating")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public List<RatingDto> getUserRatings() {
        return this.ratingService.getUserRatings();
    }
}
