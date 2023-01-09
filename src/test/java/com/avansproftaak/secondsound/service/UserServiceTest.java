package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {
    private final static String AUTHENTICATED_USER_EMAIL = "john.doe@gmail.com";

    @Autowired
    UserService sut;

    @BeforeEach
    void setUp() {
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(AUTHENTICATED_USER_EMAIL);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void can_not_register_same_user_twice() {
        User user = new User();
        user.setEmail(AUTHENTICATED_USER_EMAIL);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> sut.registerUser(user));

        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("User already exists."));
    }

    @Test
    void get_authenticated_user_returns_logged_in_user() {
        User user = sut.getAuthenticatedUser();
        assertEquals(user.getEmail(), AUTHENTICATED_USER_EMAIL);
    }
}
