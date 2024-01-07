package ru.netology;

public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) { // конструктор
        super(id); // вызов родительского конструктора
        this.title = title; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) { // метод, проверяющий подходит ли задача поисковому запросу
        if (title.contains(query)) {
            return true;
        }
        return false;
    }

    public String getTitle() { // геттер
        return title;
    }
}