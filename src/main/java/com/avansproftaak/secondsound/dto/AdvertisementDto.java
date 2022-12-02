package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.UserService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AdvertisementDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private UserDto user;
}
