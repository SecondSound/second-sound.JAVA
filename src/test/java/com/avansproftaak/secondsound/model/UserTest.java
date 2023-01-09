package com.avansproftaak.secondsound.model;

import com.avansproftaak.secondsound.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void is_user_test_data_generated() {
        System.out.println("Generating test users...");
        long count = userRepository.count();
        System.out.println("Elements: " + count);
        userRepository.findAll().forEach(System.out::println);
        System.out.println("Test users successfully generated.");

        assertEquals(count, 10);
    }
}
