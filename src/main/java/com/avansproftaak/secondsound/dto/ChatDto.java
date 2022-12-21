package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.*;
import lombok.*;

import com.avansproftaak.secondsound.model.SubCategory;
import com.avansproftaak.secondsound.service.UserService;
import lombok.*;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.List;

import java.math.BigDecimal;

@Getter
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ChatDto {

    private Long id;
    private AdvertisementDto advertisement;
    private User sender;
    private User receiver;


    public ChatDto(Long id, AdvertisementDto advertisement, User sender, User receiver) {
        this.id = id;
        this.advertisement = advertisement;
        this.sender = sender;
        this.receiver = receiver;
    }

}


