package ru.netology;

import java.util.Objects;

public class Task {
    protected int id;

    public Task(int id) { // конструктор
        this.id = id;
    }

    // Ниже метод, проверяющий подходит ли задача поисковому запросу.
    // Эта логика должна быть определена в наследниках, у каждого она будет своя
    // @param query поисковый запрос
    // @return ответ на вопрос, подходит ли эта задача под поисковый запрос
    public boolean matches(String query) {
        return false;
    }

    // Ниже находятся вспомогательные методы для корректной работы equals
    // Переопределять их в наследниках не нужно
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() { // геттер
        return id;
    }
}