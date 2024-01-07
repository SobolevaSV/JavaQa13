package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение доставки"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанк",
            "Во вторник после обеда"
    );

    @Test // тест метода добавления задачи в список дел
    public void shouldAddThreeTasksOfDifferentType() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест метода поиска с результатом добавления задачи SimpleTask
    public void shouldSearchResultSimpleTask() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест метода поиска с результатом добавления задачи Epic
    public void shouldSearchResultEpic() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест метода поиска с результатом добавления задачи Meeting
    public void shouldSearchResultMeeting() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанк");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест метода поиска с результатом добавления двух задач Epic и Meeting
    public void shouldSearchResultTwoTasks() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {epic, meeting};
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // тест метода поиска без результата добавления задачи
    public void shouldSearchNoResult() {
        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        Task[] expected = {};
        Task[] actual = todos.search("Забрать");
        Assertions.assertArrayEquals(expected, actual);
    }
}