package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.SubCategory;
import lombok.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryDto {

    private Long id;
    private String name;
    private List<SubCategory> children;

}
