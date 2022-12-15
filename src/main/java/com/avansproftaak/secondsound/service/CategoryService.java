package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.CategoryDto;
import com.avansproftaak.secondsound.model.Category;
import com.avansproftaak.secondsound.model.SubCategory;
import com.avansproftaak.secondsound.util.CategoryNameComparator;
import com.avansproftaak.secondsound.repository.CategoryRepository;
import com.avansproftaak.secondsound.repository.SubCategoryRepository;
import com.avansproftaak.secondsound.util.SubCategoryNameComparator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final CategoryRepository categoryRepository;


    public List<Category> getCategories() {
        var unSortedList = categoryRepository.findAll();

        TreeSet<Category> sortedList = new TreeSet<>(new CategoryNameComparator());
        Category removedItem = null;
        List<Category> finalList = new ArrayList<Category>();

        sortedList.addAll(unSortedList);

        for (Category category: sortedList) {

            if (Objects.equals(category.getName(), "Remainder")) {
                removedItem = category;
            } else {
                finalList.add(category);
            }
        }

        if (removedItem != null) {
            finalList.add(removedItem);
        }

        return finalList;
    }

    public List<SubCategory> getSubCategories(Long categoryId) {
        var unSortedList = subCategoryRepository.findAllByCategoryId(categoryId);

        TreeSet<SubCategory> sortedList = new TreeSet<>(new SubCategoryNameComparator());
        SubCategory removedItem = null;
        List<SubCategory> finalList = new ArrayList<>();

        sortedList.addAll(unSortedList);

        for (SubCategory subCategory: sortedList) {

            if (Objects.equals(subCategory.getName(), "Remainder")) {
                removedItem = subCategory;
            } else {
                finalList.add(subCategory);
            }
        }
        if (removedItem != null) {
            finalList.add(removedItem);
        }

        return finalList;
    }

    public ArrayList<CategoryDto> getAllCategoryDto() {
        var categoryList = getCategories();
        var categoryDtoList = new ArrayList<CategoryDto>();

        for (Category category: categoryList) {
            var subCategories = subCategoryRepository.findAllByCategoryId(category.getId());

            var newCategoryDto = new CategoryDto(category.getId(), category.getName(), subCategories);
            categoryDtoList.add(newCategoryDto);
        }

        return categoryDtoList;
    }
}
