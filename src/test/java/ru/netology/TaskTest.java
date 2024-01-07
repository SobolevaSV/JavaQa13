package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    Task task = new Task(5);

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Приложение доставки"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанк",
            "Во вторник после обеда"
    );

    @Test // тест геттера класcа Task
    public void shouldTask() {
        int expected = 5;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Task
    public void shouldMatchesTaskFalse() {
        boolean expected = false;
        boolean actual = task.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест геттера класса SimpleTask
    public void shouldSimpleTask() {
        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса SimpleTask
    public void shouldMatchesSimpleTaskTrue() {
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса SimpleTask
    public void shouldMatchesSimpleTaskFalse() {
        boolean expected = false;
        boolean actual = simpleTask.matches("Забрать");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест геттера класса Epic
    public void shouldEpic() {
        String[] expected = subtasks;
        String[] actual = epic.getSubtasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Epic
    public void shouldMatchesEpicTrue() {
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Epic
    public void shouldMatchesEpicFalse() {
        boolean expected = false;
        boolean actual = epic.matches("Картофель");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест геттера класса Meeting
    public void shouldMeeting1() {
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест геттера класса Meeting
    public void shouldMeeting2() {
        String expected = "Приложение НетоБанк";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест геттера класса Meeting
    public void shouldMeeting3() {
        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Meeting
    public void shouldMatchesMeetingTrue1() {
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Meeting
    public void shouldMatchesMeetingTrue2() {
        boolean expected = true;
        boolean actual = meeting.matches("НетоБанк");
        Assertions.assertEquals(expected, actual);
    }

    @Test // тест метода, проверяющего подходит ли задача поисковому запросу, класса Meeting
    public void shouldMatchesMeetingFalse() {
        boolean expected = false;
        boolean actual = meeting.matches("вторник");
        Assertions.assertEquals(expected, actual);
    }
}