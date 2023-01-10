package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.Category;
import com.avansproftaak.secondsound.model.SubCategory;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.UserService;
import lombok.*;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class MessageDto {

    private Long chatId;
    private String message;



}
