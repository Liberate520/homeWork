package model;

public class Task extends Plan {
    // ПОЛЯ КЛАССА
    private final String deadline;
    private final String notes;

    // КОНСТРУКТОР
    public Task(String task, String deadline, String notes) {
        super(task);
        this.deadline = deadline;
        this.notes = notes;
    }

    // ПЕРЕОПРЕДЕЛЕНИЕ ПОРЯДКА ВЫВОДА ДАННЫХ НА ПЕЧАТЬ
    public String toString() {
        return String.format("Задача:     %s\n Срок:       %s\n Примечания: %s\n", task, deadline, notes);
    }
}