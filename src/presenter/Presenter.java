package presenter;

import model.Lesson;
import model.StudyPlan;
import ui.View;
import java.util.ArrayList;


public class Presenter {
    private final StudyPlan studyPlan;
    private final View view;


    public Presenter(StudyPlan studyPlan, View view) {
        this.studyPlan = studyPlan;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.menu();
            int userDecision = view.userDecision();
            if (userDecision > 0 & userDecision < 6) {
                switch (userDecision) {                                                   // ВЫБОР ВАРИАНТА ДЕЙСТВИЙ
                    case 1 -> {                                                           // ПРОСМОТР ЗАНЯТИЙ
                        if (!studyPlan.isEmpty()) view.printAll(studyPlan.toString());
                        else view.emptyStudyPlan();
                    }
                    case 2 -> {                                                           // ДОБАВЛЕНИЕ НОВОГО ЗАНЯТИЯ
                        ArrayList<String> userInput = view.addLesson();
                        Lesson newLesson = new Lesson(userInput.get(0), userInput.get(1), userInput.get(2), userInput.get(3), userInput.get(4),
                                userInput.get(5), userInput.get(6));
                        studyPlan.add(newLesson);
                        view.addedLesson();
                    }
                    case 3 -> {                                                           // УДАЛЕНИЕ ЗАНЯТИЯ
                        if (studyPlan.isEmpty()) view.emptyStudyPlan();
                        else {
                            view.removeLesson();
                            int numberLesson = view.userChoiceRemove();
                            studyPlan.remove(numberLesson);
                            view.removeConformation();
                        }
                    }
                    case 4 -> {
                        if (studyPlan.isEmpty()) view.emptyStudyPlan();
                        else {
                            view.printAll(studyPlan.toString());
                            view.changeLesson();
                            int numberLesson = view.userChange();
                            studyPlan.remove(numberLesson);
                            ArrayList<String> userInput = view.addLesson();
                            Lesson newLesson = new Lesson(userInput.get(0), userInput.get(1), userInput.get(2), userInput.get(3), userInput.get(4),
                                    userInput.get(5), userInput.get(6));
                            studyPlan.add(newLesson);
                            view.changeConformation();
                        }
                    }
                    case 5 -> {
                        return;
                    }
                }
            }
            else {  // ПРОВЕРКА ПРАВИЛЬНОСТИ ВВОДА ДАННЫХ ПОЛЬЗОВАТЕЛЕМ ПРИ РАБОТЕ С МЕНЮ
                System.out.printf("\nВ списке нет числа %s\n", userDecision + ". Введите корректное значение.");
                System.out.println();
            }
        }
    }
}