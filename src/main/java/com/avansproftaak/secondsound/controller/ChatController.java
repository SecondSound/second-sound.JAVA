package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.*;
import com.avansproftaak.secondsound.model.*;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.service.AdvertisementService;
import com.avansproftaak.secondsound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;


    @RestController
    @RequestMapping(path="api/v1.0/")

    public class ChatController {
        private final ChatService chatService;
        private final AdvertisementService advertisementService;
        private final UserService userService;
        private final AdvertisementRepository advertisementRepository;
        private final MessageService messageService;

        @Autowired
        public ChatController(ChatService chatService, AdvertisementService advertisementService, AdvertisementRepository advertisementRepository, UserService userService, MessageService messageService) {
            this.advertisementService = advertisementService;
            this.userService = userService;
            this.advertisementRepository = advertisementRepository;
            this.chatService = chatService;
            this.messageService = messageService;
        }

        @GetMapping(path="chat")
        public List<ChatDto> findAllChat() {
            System.out.println("findallchat");
            return chatService.getAllChats();
        }

        @GetMapping(path="chat/{id}")
        public ChatDto findChatById(@PathVariable Long id) {
            System.out.println("hit with id" + id);
            return chatService.getChatById(id);
        }

        @PostMapping(path = "chat")
        public ChatDto AddChat(@RequestBody Chat chat) {

            return chatService.addChat(chat);
        }

        @PostMapping(path = "chat/create/{id}")
        public String startChat(@RequestBody IdDto id) {

            System.out.println("hit by " + id);
            var advertisement = advertisementRepository.findById(id.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));

            Chat chat = new Chat(
                    advertisement,
                    userService.getAuthenticatedUser(),
                    advertisement.getUser()
            );
            ChatDto savedChat = chatService.addChat(chat);
            System.out.println(savedChat.getId());
            var chatId = savedChat.getId().toString();
            return chatId;
        }

}
