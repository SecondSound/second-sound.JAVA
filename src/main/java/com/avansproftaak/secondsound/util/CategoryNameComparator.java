package com.avansproftaak.secondsound.util;

import com.avansproftaak.secondsound.model.Category;

import java.util.Comparator;

public class CategoryNameComparator implements Comparator<Category> {
    public int compare(Category category1, Category category2) {
        return category1.getName().compareTo(category2.getName());
    }
}
