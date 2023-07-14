package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class NextOfKin extends Command{
    public NextOfKin(ConsoleUI console) {
        super(console);
        description = "Показать ближайших родственников человека и степень родства";
    }

    @Override
    public void execute() {
        console.nextOfKin();
    }
}
