package com.avansproftaak.secondsound.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDto {
    private Long ratedByUserId;
    private UserDto user;
    private int rating;
}
