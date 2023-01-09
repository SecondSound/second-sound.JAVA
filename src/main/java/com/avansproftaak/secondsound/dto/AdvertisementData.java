package com.avansproftaak.secondsound.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
public class AdvertisementData {

    private String title;
    private String description;
    private String price;
    private Integer subCategoryId;
    private boolean isActive;
}
