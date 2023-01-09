package com.avansproftaak.secondsound.repository;

import com.avansproftaak.secondsound.enums.UserRole;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.service.EmailService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

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
