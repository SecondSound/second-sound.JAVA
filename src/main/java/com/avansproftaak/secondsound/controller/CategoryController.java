package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.CategoryDto;
import com.avansproftaak.secondsound.model.Category;
import com.avansproftaak.secondsound.model.SubCategory;
import com.avansproftaak.secondsound.repository.SubCategoryRepository;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


@RestController
@RequestMapping(path="api/v1.0/")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path="public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping(path="public/subcategories/{id}")
    public List<SubCategory> getAllSubCategories(@PathVariable Long id) {

        return categoryService.getSubCategories(id);
    }
    
    @GetMapping(path="public/categories/dto")
    public List<CategoryDto> getAllCategoriesDto() {
        return categoryService.getCategoriesDto();
    }

}
