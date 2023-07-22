package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;

public class HumanPatronymic extends HumanData{
    public HumanPatronymic(ConsoleUI console, Container container) {
        super(console, container);
        description = "Отчество";
    }

    @Override
    public void execute() {
        System.out.println("Введите отчество:");
        String patronymic = scanner.nextLine();
        container.setPatronymic(patronymic);
        //console.getPresenter().setHumanPatronymic(patronymic);
    }
}
