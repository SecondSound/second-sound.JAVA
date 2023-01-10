package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.RatingDto;
import com.avansproftaak.secondsound.model.Rating;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.RatingService;
import com.avansproftaak.secondsound.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/{id}")
    public RatingDto updateRating(@PathVariable("id") Long id, @RequestBody Rating newRating) {
        User user = userService.getAuthenticatedUser();
        return this.ratingService.updateRating(user, newRating, id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable("id") Long id) {
        User user = userService.getAuthenticatedUser();
        return this.ratingService.deleteRating(id, user);
    }
}
