package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

    @Test
    void sameInputShouldProduceSameHash() {
        String a = PasswordUtil.hash("1234");
        String b = PasswordUtil.hash("1234");
        assertEquals(a, b);
    }

    @Test
    void hashShouldDifferFromSource() {
        assertNotEquals("1234", PasswordUtil.hash("1234"));
    }
}