package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.MessageDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.*;
import com.avansproftaak.secondsound.repository.*;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final ChatService chatService;
    private final ChatRepository chatRepository;


    public List<Message> getAllMessages() {
        return messageRepository.findAll();

    }

    public List<Message> getMessagesByChat(Long id) {
        return messageRepository.findAllByChat(id);
    }


    public Message addMessage(MessageDto message) {
        User sender = userService.getAuthenticatedUser();

        // if the sender is owner of the add make other receiver
        // else make owner receiver (get vars from the chat)

        Chat chat = chatRepository.findById(message.getChatId()) .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chat not found"));

        User receiver = chat.getReceiver();
        if (receiver == sender){
           receiver = chat.getSender();
        }


        Message newMessage = new Message(
                message.getChatId(),
                message.getMessage(),
                sender,
                receiver
        );

        System.out.println(message.getMessage());

        messageRepository.save(newMessage);
        return newMessage;
    }
}
