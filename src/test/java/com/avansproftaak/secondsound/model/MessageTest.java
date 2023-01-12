package com.avansproftaak.secondsound.model;

import com.avansproftaak.secondsound.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest

public class MessageTest {

    @Autowired
    MessageRepository messageRepository;

    @Test
    public void is_chat_data_generated() {
        long count = messageRepository.count();
        System.out.println("Number of messages: " + count + " should be: 3");
        assertEquals(4, count);
    }
}
