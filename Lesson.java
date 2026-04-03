package model;

import java.util.List;

public class Lesson {
    private final int id;
    private final String title;
    private final String topic;
    private final String content;
    private final List<Question> questions;

    public Lesson(int id, String title, String topic, String content, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.topic = topic;
        this.content = content;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return title;
    }
}