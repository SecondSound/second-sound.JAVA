package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.SavedAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavedAdvertisementRepository extends JpaRepository<SavedAdvertisement, Long> {

    @Query("SELECT s FROM SavedAdvertisement s WHERE s.user.id =?1")
    List<SavedAdvertisement> findByUserId(Long userId);

    @Query("SELECT s FROM SavedAdvertisement s WHERE s.user.id =?1 AND s.advertisement.id =?2")
    Optional<SavedAdvertisement> checkIfExist(Long id, Long id1);
}
