package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    @Query("SELECT s FROM SubCategory s WHERE s.category.id =?1")
    List<SubCategory> findAllByCategoryId(Long categoryId);
}
