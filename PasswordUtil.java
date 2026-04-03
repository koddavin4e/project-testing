package service;

import model.TypingResult;
import repository.TypingResultRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TypingService {
    private final TypingResultRepository repository = new TypingResultRepository();
    private final Random random = new Random();

    private static final Map<String, List<String>> TEXTS;
    static {
        TEXTS = new java.util.HashMap<>();
        TEXTS.put("JAVA", Arrays.asList(
                "public class Main { public static void main(String[] args) { System.out.println(\"Hello\"); } }",
                "for (int i = 0; i < 10; i++) { sum += i; }",
                "if (user != null && user.getName() != null) { System.out.println(user.getName()); }"
        ));
        TEXTS.put("SQL", Arrays.asList(
                "SELECT * FROM users WHERE email = 'test@mail.com';",
                "INSERT INTO users(username, email) VALUES ('alan', 'alan@mail.com');",
                "UPDATE users SET email = 'new@mail.com' WHERE id = 1;"
        ));
        TEXTS.put("TEXT", Arrays.asList(
                "Хороший программист сначала анализирует проблему, потом ищет причину и только потом исправляет код.",
                "Тренировка печати кода помогает быстрее писать и лучше замечать ошибки.",
                "Практика, тестирование и работа с базой данных делают студента сильнее."
        ));
    }

    public String getRandomText(String mode) {
        List<String> list = TEXTS.getOrDefault(mode, TEXTS.get("TEXT"));
        return list.get(random.nextInt(list.size()));
    }

    public void saveResult(int userId, TypingResult result) {
        repository.save(userId, result);
    }

    public List<TypingResult> getHistory(int userId) {
        return repository.findByUserId(userId);
    }
}