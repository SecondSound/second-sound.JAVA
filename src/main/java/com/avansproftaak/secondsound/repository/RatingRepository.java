package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Rating;
import com.avansproftaak.secondsound.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r.rating FROM Rating r WHERE r.user =?1")
    List<Rating> findAllByUser(User user);

    @Query("SELECT r FROM Rating r WHERE r.ratedByUser =?1")
    List<Rating> findAllByRater(User user);
}
