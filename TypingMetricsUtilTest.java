package util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TypingMetricsUtilTest {

    @Test
    void shouldCalculateAccuracy() {
        assertEquals(80.0, TypingMetricsUtil.calculateAccuracy("hello", "helxo"));
    }

    @Test
    void shouldCalculateWpm() {
        assertEquals(2.0, TypingMetricsUtil.calculateWPM("abcdefghij", 60));
    }

    @Test
    void shouldCountMistakes() {
        assertEquals(1, TypingMetricsUtil.countMistakes("hello", "helxo"));
    }
}