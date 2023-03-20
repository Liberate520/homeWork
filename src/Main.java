import model.Lesson;
import model.StudyPlan;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {

        Lesson lesson1 = new Lesson("OOP", "Семинар", "Константин Актыбаев",
                "SOLID", "21 марта 2023 года", "10.00","Изучить детально.");
        Lesson lesson2 = new Lesson("Финансовый менеджмент", "Семинар", "Мансур Шафигуллин",
                "Экономические эффекты проекта", "20 марта 2023 года", "19.00", "Иметь представление.");
        Lesson lesson3 = new Lesson("Волшебство", "практическое занятие", "профессор Дамблдор",
                "Магия в IT", "22,5 марта 2023 года", "00.00", "Быть обязательно!");
        StudyPlan studyPlan = new StudyPlan();
        studyPlan.add(lesson1);
        studyPlan.add(lesson2);
        studyPlan.add(lesson3);

        View view = new ConsoleUI();
        Presenter presenter = new Presenter(studyPlan, view);

        presenter.start();
    }
}