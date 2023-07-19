package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class ReturnToFirstMenu extends Command{
    public ReturnToFirstMenu(ConsoleUI console) {
        super(console);
        description = "Вернуться к стартовому меню";
    }

    @Override
    public void execute() {
        console.returnToFirstMenu();
    }
}