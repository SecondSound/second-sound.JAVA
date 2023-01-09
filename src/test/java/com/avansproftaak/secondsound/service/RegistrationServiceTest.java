package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.RegistrationDto;
import com.avansproftaak.secondsound.dto.TokenDto;
import com.avansproftaak.secondsound.model.ConfirmationToken;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.ConfirmationTokenRepository;
import com.avansproftaak.secondsound.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RegistrationServiceTest {

    @Autowired
    RegistrationService sut;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ConfirmationTokenRepository confirmationTokenRepository;

    private RegistrationDto registrationDto;

    @BeforeEach
    void setUp() {
        registrationDto = new RegistrationDto(
                "John",
                "Doe",
                "john.doe@example.com",
                "password123"
        );
    }

    @AfterEach
    void tearDown() {
        userRepository.delete(userRepository.findByEmail(registrationDto.getEmail()).get());
    }

    @Test
    void register_user_saves_user_returns_confirmation_token() {
        TokenDto tokenDto = sut.register(registrationDto);
        Optional<User> user = userRepository.findByEmail(registrationDto.getEmail());
        assertNotNull(user);
        assertNotNull(tokenDto.getToken());
    }

    @Test
    void confirm_token_enables_user() {
        TokenDto tokenDto = sut.register(registrationDto);
        sut.confirmToken(tokenDto.getToken());

        User user = userRepository.findByEmail("john.doe@example.com").get();
        assertNotNull(user);
        assertTrue(user.isEnabled());
    }

    @Test
    void confirm_user_throws_exception_if_token_is_expired() {
        TokenDto tokenDto = sut.register(registrationDto);
        ConfirmationToken token = confirmationTokenRepository.findByToken(tokenDto.getToken()).get();
        token.setExpiredAt(LocalDateTime.now().minusMinutes(5));
        confirmationTokenRepository.save(token);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> sut.confirmToken(token.getToken()));

        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("Confirmation token has expired."));
    }

    @Test
    void user_cannot_be_confirmed_twice() {
        TokenDto tokenDto = sut.register(registrationDto);
        sut.confirmToken(tokenDto.getToken());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> sut.confirmToken(tokenDto.getToken()));

        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("Account has already been confirmed."));
    }
}
