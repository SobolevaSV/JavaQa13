package ru.netology;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) { // конструктор
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    @Override
    public boolean matches(String query) { // метод, проверяющий подходит ли задача поисковому запросу
        for (int i = 0; i < subtasks.length; i++) {
            if (subtasks[i].contains(query)) {
                return true;
            }
        }
        return false;
    }

    public String[] getSubtasks() { // геттер
        return subtasks;
    }
}