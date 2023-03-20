package model;

import java.util.ArrayList;

public class StudyPlan {

    // ЗАПИСЬ ЗАНЯТИЙ В СПИСОК
    private final ArrayList<Lesson> lessons = new ArrayList<>();

    // ПЕРЕОПРЕДЕЛЕНИЕ СПОСОБА ВЫВОДА ДАННЫХ НА ПЕЧАТЬ
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nРАСПИСАНИЕ ЗАНЯТИЙ:\n");
        for (int i = 0; i < lessons.size(); i++) {
            sb.append("\nЗанятие № ").append(i+1).append("\n").append(lessons.get(i)).append("\n");
        }
        return sb.toString();
    }

    // МЕТОДЫ КЛАССА StudyPlan
    public void add(Lesson note){          // Добавление нового занятия в учебный план.
        lessons.add(note);
    }

    public void remove(int number){        // Удаление занятия по его номеру.
        lessons.remove(number - 1);
    }

    public boolean isEmpty(){              // Уведомление о том, что план пуст.
        return lessons.isEmpty();
    }
}