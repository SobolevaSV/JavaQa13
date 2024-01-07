package ru.netology;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) { // конструктор
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project; // заполнение своих полей
        this.start = start; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) { // метод, проверяющий подходит ли задача поисковому запросу
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

    public String getTopic() { // геттер
        return topic;
    }

    public String getProject() { // геттер
        return project;
    }

    public String getStart() { // геттер
        return start;
    }
}