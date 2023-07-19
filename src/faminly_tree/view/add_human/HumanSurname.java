package faminly_tree.view.add_human;

import faminly_tree.model.human.Human;
import faminly_tree.view.ConsoleUI;

public class HumanSurname extends HumanData{

    public HumanSurname(ConsoleUI console) {
        super(console);
        description = "Фамилия";
    }

    @Override
    public void execute() {
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        console.getPresenter().setHumanSurname(surname);
    }

}
