package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.Category;
import com.avansproftaak.secondsound.model.Resource;
import com.avansproftaak.secondsound.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findAllByAdvertisement(Advertisement advertisement);

    List<Resource> findAllByCategory(Category category);

    List<Resource> findAllBySubCategory(SubCategory subCategory);


    @Query("SELECT r.filePath FROM Resource r WHERE r.advertisement.id =?1")
    String findImagesByAdvertisementId(Long id);
}
