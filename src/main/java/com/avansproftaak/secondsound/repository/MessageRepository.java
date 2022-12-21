package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT a FROM Message a WHERE a.chatId =?1 ")
    List<Message> findAllByChat(Long id);

}
