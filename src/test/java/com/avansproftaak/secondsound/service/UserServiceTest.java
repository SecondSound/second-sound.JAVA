package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService sut;

    @Test
    void can_not_register_same_user_twice() {
        User user = new User();
        user.setEmail("john.doe@gmail.com");
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> sut.registerUser(user));

        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("User already exists."));
    }
}
