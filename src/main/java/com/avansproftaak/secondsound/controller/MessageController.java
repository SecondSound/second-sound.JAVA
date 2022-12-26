package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.MessageDto;
import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.Message;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.ChatService;
import com.avansproftaak.secondsound.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path="api/v1.0/")

public class MessageController {
    private final ChatService chatService;
    private final AdvertisementService advertisementService;
    private final MessageService messageService;

    @Autowired
    public MessageController(ChatService chatService, AdvertisementService advertisementService, MessageService messageService) {
        this.advertisementService = advertisementService;
        this.chatService = chatService;
        this.messageService = messageService;
    }


    @GetMapping(path="public/message")
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping(path="public/message/{id}")
    public List<Message> getMessagesByChat(@PathVariable Long id) {
        return messageService.getMessagesByChat(id);
    }

    @PostMapping(path = "message")
    public Message AddMessage( @RequestBody MessageDto message) {

        return messageService.addMessage(message);
    }


}
