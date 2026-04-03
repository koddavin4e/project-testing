package ui;

import model.Lesson;
import model.Question;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonPanel extends JPanel {

    public LessonPanel(AppFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        List<Lesson> lessons = frame.getLessonRepository().findAll();

        JList<Lesson> lessonList = new JList<>(lessons.toArray(new Lesson[0]));
        JTextArea contentArea = new JTextArea();
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);

        JButton quizButton = new JButton("Пройти тест");
        JButton backButton = new JButton("Назад");

        lessonList.addListSelectionListener(e -> {
            Lesson lesson = lessonList.getSelectedValue();
            if (lesson != null) {
                contentArea.setText("Тема: " + lesson.getTopic() + "\n\n" + lesson.getContent());
            }
        });

        quizButton.addActionListener(e -> {
            Lesson lesson = lessonList.getSelectedValue();
            if (lesson == null) {
                JOptionPane.showMessageDialog(frame, "Сначала выбери урок");
                return;
            }

            Map<Integer, String> answers = new HashMap<>();

            for (Question q : lesson.getQuestions()) {
                Object[] options = {
                        "A. " + q.getOptionA(),
                        "B. " + q.getOptionB(),
                        "C. " + q.getOptionC(),
                        "D. " + q.getOptionD()
                };

                int result = JOptionPane.showOptionDialog(
                        frame,
                        q.getQuestionText(),
                        "Вопрос",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (result == 0) answers.put(q.getId(), "A");
                if (result == 1) answers.put(q.getId(), "B");
                if (result == 2) answers.put(q.getId(), "C");
                if (result == 3) answers.put(q.getId(), "D");
            }

            int score = frame.getQuizService().calculateScore(lesson, answers);
            JOptionPane.showMessageDialog(frame, "Результат: " + score + " из " + lesson.getQuestions().size());
        });

        backButton.addActionListener(e -> frame.showDashboard());

        JPanel left = new JPanel(new BorderLayout());
        left.add(new JLabel("Уроки"), BorderLayout.NORTH);
        left.add(new JScrollPane(lessonList), BorderLayout.CENTER);

        JPanel right = new JPanel(new BorderLayout());
        right.add(new JLabel("Содержание"), BorderLayout.NORTH);
        right.add(new JScrollPane(contentArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(quizButton);
        bottom.add(backButton);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
        split.setDividerLocation(250);

        add(split, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}