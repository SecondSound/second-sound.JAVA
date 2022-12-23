package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.*;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


    @RestController
    @RequestMapping(path="api/v1.0/")

    public class ChatController {
        private final ChatService chatService;
        private final AdvertisementService advertisementService;
        private final MessageService messageService;

        @Autowired
        public ChatController(ChatService chatService, AdvertisementService advertisementService, MessageService messageService) {
            this.advertisementService = advertisementService;
            this.chatService = chatService;
            this.messageService = messageService;
        }

        @GetMapping(path="chat")
        public List<ChatDto> findAllChat() {
            System.out.println("findallchat");
            return chatService.getAllChats();
        }

/*        @GetMapping(path="public/chat/{username}")
        public List<Chat> findBySenderOrReceiver(@PathVariable String username) {
            return chatService.loadChatBySenderOrReceiver(username);
        }*/

}
