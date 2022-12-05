package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.UserService;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AdvertisementDto {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String imgFile;
    private Long user;
}
