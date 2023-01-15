package homeWork.src.commands;

import homeWork.src.ui.ConsoleUI;
/*
показать всех сестёр члена семьи
 */

public class Command_5 implements Commands {
    ConsoleUI consoleUI;

    public Command_5(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllSisters(str));
    }

    @Override
    public String description() {
        return "показать всех сестёр члена семьи";
    }
}
