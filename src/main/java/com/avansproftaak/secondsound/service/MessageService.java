package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.Message;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.MessageRepository;
import com.avansproftaak.secondsound.repository.ResourceRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;



@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;


    public List<Message> getAllMessages() {
        return messageRepository.findAll();

    }

    public List<Message> getMessagesByChat(Long id) {
        return messageRepository.findAllByChat(id);
    }



}
