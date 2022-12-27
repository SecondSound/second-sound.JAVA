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
@Setter
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
    private SubCategory subCategory;
    private SellerDto seller;
    private boolean isSaved;

    public AdvertisementDto(Long id, String title, String description, BigDecimal price, String imgFile, SubCategory subCategory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgFile = imgFile;
        this.subCategory = subCategory;
    }

    public AdvertisementDto(Long id, String title, String description, BigDecimal price, String imgFile, SubCategory subcategory, SellerDto seller) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imgFile = imgFile;
        this.subCategory = subcategory;
        this.seller = seller;
    }
}
