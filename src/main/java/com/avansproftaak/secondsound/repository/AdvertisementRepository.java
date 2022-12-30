package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    @Query("SELECT a FROM Advertisement a WHERE a.user.id =?1 AND a.isActive =?2")
    List<Advertisement> findAllBySellerId(Long sellerId, boolean isActive);

    List<Advertisement> findAllByUser(User user);

    @Query("SELECT a FROM Advertisement a WHERE a.description LIKE ?1 OR a.title LIKE ?1")
    List<Advertisement> findAllByQuery(String query);
}
