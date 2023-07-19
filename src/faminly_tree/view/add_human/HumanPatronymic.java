package faminly_tree.view.add_human;

import faminly_tree.model.human.Human;
import faminly_tree.view.ConsoleUI;

public class HumanPatronymic extends HumanData{
    public HumanPatronymic(ConsoleUI console) {
        super(console);
        description = "Отчество";
    }

    @Override
    public void execute() {
        System.out.println("Введите отчество:");
        String patronymic = scanner.nextLine();
        console.getPresenter().setHumanPatronymic(patronymic);
    }
}
