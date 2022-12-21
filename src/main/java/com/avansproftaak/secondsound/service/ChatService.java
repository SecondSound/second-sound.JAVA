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
        var chats = chatRepository.findAll();
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

//    public List<AdvertisementDto> getAllCats() {
//
//        var adList = advertisementRepository.findAll();
//        ArrayList<AdvertisementDto> adListDto = new ArrayList<>();
//
//        for (Advertisement advertisement : adList) {
//
//            var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
//                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));
//
//            var seller = userService.getSeller(advertisement.getUser().getId());
//
//            var advertisementDto = new AdvertisementDto(
//                    advertisement.getId(),
//                    advertisement.getTitle(),
//                    advertisement.getDescription(),
//                    advertisement.getPrice(),
//                    resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
//                    subcategory,
//                    seller);
//
//            adListDto.add(advertisementDto);
//        }
//        return adListDto;
//
//    }


/*    public List<Chat> loadChatBySenderOrReceiver(String user) throws ResponseStatusException {
        return chatRepository.findBySenderOrReceiver(user, user).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "No chats found for user " + user ));
    }*/

    public ChatDto getChat(Chat chat) {

        return new ChatDto(
                chat.getId(),
                advertisementService.getAdvertisement(chat.getAdvertisement()),
                chat.getSender(),
                chat.getReceiver());
    }

    public ChatDto addAdvertisement(Chat chat) {

        User user = userService.getAuthenticatedUser();

        Chat newChat = new Chat(chat.getAdvertisement(), chat.getSender(), chat.getReceiver());
        chatRepository.save(newChat);

        return getChat(newChat);
    }


}




