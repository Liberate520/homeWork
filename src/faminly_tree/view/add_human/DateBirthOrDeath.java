package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;
import faminly_tree.view.examination.Exam;

import java.time.LocalDate;

public abstract class DateBirthOrDeath extends HumanData{
    Exam exam = new Exam();
    LocalDate value;
    private final String YEAR = "Укажите год, если он неизвестен введите 0:";
    private final String MONTH = "Укажите месяц, если он неизвестен введите 0:";
    private final String DAY = "Укажите день, если он неизвестен введите 0:";
    public DateBirthOrDeath(ConsoleUI console, Container container) {
        super(console, container);
    }
    @Override
    public void execute() {
        int year = data(YEAR);
        while (exam.yearExamination(year)) {
            year = data(YEAR);
        }
        int month = data(MONTH);
        while (exam.monthExamination(month)) {
            month = data(MONTH);
        }
        int day = data(DAY);
        while (exam.dayExamination(day, month, year)) {
            day = data(DAY);
        }
        value = LocalDate.of(year, month, day);
    }
    private int data(String descr){
        String str;
        System.out.println(descr);
        str = scanner.nextLine();
        int data = exam.itsNumber(str);
        if (data == -1) {
            data(descr);
        }
        return data;
    }
}
