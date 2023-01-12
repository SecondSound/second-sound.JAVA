package com.avansproftaak.secondsound.model;

import com.avansproftaak.secondsound.repository.ChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChatTest {

    @Autowired
    ChatRepository chatRepository;

    @Test
    public void is_chat_data_generated() {
        long count = chatRepository.count();
        System.out.println("Number of chats: " + count + " should be: 3");
        assertEquals(4, count);
    }
}
