package service;

import model.Lesson;
import model.Question;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizServiceTest {

    @Test
    void shouldCalculateScore() {
        Lesson lesson = new Lesson(
                1,
                "Test",
                "Java",
                "Content",
                Arrays.asList(
                        new Question(1, "Q1", "A1", "B1", "C1", "D1", "A"),
                        new Question(2, "Q2", "A2", "B2", "C2", "D2", "B")
                )
        );

        QuizService service = new QuizService();
        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "A");
        answers.put(2, "C");
        int score = service.calculateScore(lesson, answers);

        assertEquals(1, score);
    }
}