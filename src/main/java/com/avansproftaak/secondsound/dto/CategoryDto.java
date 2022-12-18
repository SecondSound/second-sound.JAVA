package com.avansproftaak.secondsound.dto;

import com.avansproftaak.secondsound.model.SubCategory;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CategoryDto {

    public Long id;
    public String name;
    public List<SubCategory> children;
    
}
