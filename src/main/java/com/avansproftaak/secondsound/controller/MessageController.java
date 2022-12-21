package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.Message;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.ChatService;
import com.avansproftaak.secondsound.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

//        @PostMapping(path = "advertisement")
//        public AdvertisementDto AddAdvertisement(@RequestBody Advertisement advertisement) {
//
//            return advertisementService.addAdvertisement(advertisement);
//        }


}
