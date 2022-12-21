package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
