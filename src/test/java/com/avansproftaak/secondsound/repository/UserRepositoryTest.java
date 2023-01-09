package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserRepositoryTest {

    UserRepository mockUserRepository = mock(UserRepository.class);
    User user = mock(User.class);

    @Test
    void is_find_user_by_email_returning_user() {
        when(user.getEmail()).thenReturn("john.doe@example.com");
        Optional<User> userByEmailOptional = mockUserRepository.findByEmail(user.getEmail());
        assertNotNull(userByEmailOptional);
    }
}
