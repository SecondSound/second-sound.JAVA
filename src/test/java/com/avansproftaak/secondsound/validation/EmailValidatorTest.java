package com.avansproftaak.secondsound.validation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class EmailValidatorTest {

    EmailValidator validator = new EmailValidator();

    @Test
    void email_validator_expect_false() {
        boolean isValidEmail = validator.test("ThisisNoEmail");

        assertFalse(isValidEmail);
    }

    @Test
    void email_validator_expect_true() {
        boolean isValidEmail = validator.test("thisis@anemail.com");

        assertTrue(isValidEmail);
    }
}
