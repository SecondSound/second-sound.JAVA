package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.id =?1")
    Category findBySubCategoryId(Long id);
}
