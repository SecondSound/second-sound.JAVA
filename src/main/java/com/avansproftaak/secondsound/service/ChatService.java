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
import java.util.Optional;

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

        User user = userService.getAuthenticatedUser();

        if ((chat.getSender() == user) || (chat.getReceiver() == user )){
            return new ChatDto(
                    chat.getId(),
                    advertisementService.getAdvertisement(chat.getAdvertisement()),
                    chat.getSender(),
                    chat.getReceiver());
        } else {
            return new ChatDto();

        }
    }

    public ChatDto addChat(Chat chat) {

        User user = userService.getAuthenticatedUser();
//        todo: if chat exist go to chat
        Chat newChat = new Chat(chat.getAdvertisement(), chat.getSender(), chat.getReceiver());
        chatRepository.save(newChat);

        return getChat(newChat);
    }


    public ChatDto getChatById(Long id) {
        System.out.println("hit");
        Chat chat = chatRepository.findById(id).orElse(null);
        System.out.println("create dto");
        System.out.println(chat.getAdvertisement());
        AdvertisementDto add = advertisementService.getAdvertisement(chat.getAdvertisement());
        System.out.println("add " + add);
        ChatDto chatDto = new ChatDto(
                chat.getId(),
                add,
                chat.getSender(),
                chat.getReceiver()

        );
        System.out.println("return dto");
        return chatDto;
    }
}




