package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;
import faminly_tree.view.examination.Exam;

public class Gender extends  HumanData{
    Exam exam = new Exam();
    public Gender(ConsoleUI console) {
        super(console);
        description = "Пол";
    }
    @Override
    public void execute() {
        System.out.println("Введите имя:");
        String sex = scanner.nextLine();
        if (!exam.rightGender(sex)) System.out.println("Некорректно указан пол");
        else console.getPresenter().setHumanGender(sex);
    }
}
