package faminly_tree.view.add_human;

import faminly_tree.view.ConsoleUI;

public class HumanSurname extends HumanData{

    public HumanSurname(ConsoleUI console, Container container) {
        super(console, container);
        description = "Фамилия";
    }

    @Override
    public void execute() {
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        container.setSurname(surname);
        //console.getPresenter().setHumanSurname(surname);
    }

}
