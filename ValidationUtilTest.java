package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtilTest {

    @Test
    void usernameShouldBeValid() {
        assertTrue(ValidationUtil.isValidUsername("alan"));
    }

    @Test
    void shortUsernameShouldBeInvalid() {
        assertFalse(ValidationUtil.isValidUsername("ab"));
    }

    @Test
    void emailShouldBeValid() {
        assertTrue(ValidationUtil.isValidEmail("test@mail.com"));
    }

    @Test
    void wrongEmailShouldBeInvalid() {
        assertFalse(ValidationUtil.isValidEmail("wrong"));
    }
}