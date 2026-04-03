package service;

import model.Lesson;
import model.Question;

import java.util.Map;

public class QuizService {
    public int calculateScore(Lesson lesson, Map<Integer, String> answers) {
        int score = 0;
        for (Question q : lesson.getQuestions()) {
            String userAnswer = answers.get(q.getId());
            if (userAnswer != null && userAnswer.equalsIgnoreCase(q.getCorrectOption())) {
                score++;
            }
        }
        return score;
    }
}