package com.avansproftaak.secondsound.util;

import com.avansproftaak.secondsound.model.Category;
import com.avansproftaak.secondsound.model.SubCategory;

import java.util.Comparator;

public class SubCategoryNameComparator implements Comparator<SubCategory> {
    public int compare(SubCategory subCategory1, SubCategory subCategory2) {
        return subCategory1.getName().compareTo(subCategory2.getName());
    }
}
