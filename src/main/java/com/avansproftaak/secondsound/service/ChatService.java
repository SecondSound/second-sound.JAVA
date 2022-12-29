package com.avansproftaak.secondsound.service;


import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.ChatDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.ChatRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserService userService;
    private final AdvertisementService advertisementService;


    public List<ChatDto> getAllChats() {
        User user = userService.getAuthenticatedUser();

        System.out.println(user.getId());
        var chats = chatRepository.findBySenderOrReceiver(user,user);
        ArrayList<ChatDto> chatsDtoList = new ArrayList<>();


        for (Chat chat : chats) {

            var chatDto = new ChatDto(
                    chat.getId(),
                    advertisementService.getAdvertisement(chat.getAdvertisement()),
                    chat.getSender(),
                    chat.getReceiver());

            var add = chatDto.getAdvertisement();
            chatsDtoList.add(chatDto);
        }
        return chatsDtoList;

        }

    public ChatDto getChat(Chat chat) {

        return new ChatDto(
                chat.getId(),
                advertisementService.getAdvertisement(chat.getAdvertisement()),
                chat.getSender(),
                chat.getReceiver());
    }

    public ChatDto addChat(Chat chat) {

        User user = userService.getAuthenticatedUser();
//        todo: if chat exist go to chat
        Chat newChat = new Chat(chat.getAdvertisement(), chat.getSender(), chat.getReceiver());
        chatRepository.save(newChat);

        return getChat(newChat);
    }


}




