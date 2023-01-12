package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.ChatDto;
import com.avansproftaak.secondsound.model.Chat;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.ChatRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ChatsServiceTest {

    @Autowired
    ChatService sut;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;

    private ChatDto chatDto;
    private Chat chat;
    private  User user;


    @BeforeEach
    void setUp() {
        user = userRepository.findById(1L).get();
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(user.getEmail());
        UserService userService = Mockito.mock(UserService.class);
        when(userService.getAuthenticatedUser()).thenReturn(user);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);



        chat = new Chat(

                advertisementRepository.findById(1L).get(),
                userRepository.findById(1L).get(),
                userRepository.findById(2L).get()

        );
        chat.setId(10L);
        System.out.println("sender: " + chat.getSender().getFirstName());
    }

    @AfterEach
    void tearDown() {
        chatRepository.delete(chat);
    }

    @Test
    void test_authentication_chat_adds_chat() {
        chatDto = sut.addChat(chat);
        System.out.println(chatDto);
        Optional<Chat> createdChat = chatRepository.findById(10L);

        // because the chat is not saved as a authenticated user we should return empty chat
        assertEquals(true, createdChat.isEmpty());
    }


}