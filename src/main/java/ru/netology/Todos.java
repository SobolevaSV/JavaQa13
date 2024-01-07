package ru.netology;

public class Todos {

    private Task[] tasks = new Task[0]; // <- тут будут все задачи

    // Ниже вспомогательный метод для имитации добавления элемента в массив
    // @param current массив, в который мы хотим добавить элемент
    // @param task элемент, который мы хотим добавить
    // @return возвращает новый массив, который выглядит как тот, что мы передали,
    // но с добавлением нового элемента в конец
    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    // Ниже метод добавления задачи в список дел
    // @param task добавляемая задача
    public void add(Task task) { // <- вот здесь в параметре может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }

    // Ниже метод поиска задач, которые подходят под поисковый запрос
    // @param query поисковый запрос
    // @return возвращает массив из подошедших задач
    public Task[] search(String query) {
        Task[] result = new Task[0]; // массив для ответа
        for (Task task : tasks) { // перебираем все задачи
            if (task.matches(query)) { // если задача подходит под запрос
                result = addToArray(result, task); // добавляем её в массив ответа
            }
        }
        return result;
    }
}