package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.RatingDto;
import com.avansproftaak.secondsound.model.Rating;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final ModelMapper modelmapper;

    public List<RatingDto> getUserRatings(User user) {

        return ratingRepository.findAllByRater(user)
                .stream()
                .map(obj -> modelmapper.map(obj, RatingDto.class))
                .collect(Collectors.toList());
    }

    public Float getSellerRating(User user) {
        List<Integer> ratings = ratingRepository.findAllByUser(user);
        return (float)ratings.stream().mapToInt(Integer::intValue).sum() / ratings.size();
    }

    public RatingDto updateRating(User user, Rating newRating, Long id) {
        Rating rating = ratingRepository.getReferenceById(id);

        if (rating.getRatedByUser() != user) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User cannot update this rating.");
        }
        rating.setRating(newRating.getRating());

        return modelmapper.map(ratingRepository.save(rating), RatingDto.class);
    }

    public ResponseEntity<String> deleteRating(Long id, User user) {
        Rating rating = ratingRepository.getReferenceById(id);

        if (rating.getRatedByUser() != user) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User cannot delete this rating.");
        }
        ratingRepository.delete(rating);
        return new ResponseEntity<>("Rating successfully deleted.", HttpStatus.OK);
    }
}
