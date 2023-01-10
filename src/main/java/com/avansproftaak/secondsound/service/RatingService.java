package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.RatingDto;
import com.avansproftaak.secondsound.model.Rating;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
