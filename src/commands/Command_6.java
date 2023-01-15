package homeWork.src.commands;

import homeWork.src.ui.ConsoleUI;
/*
показать всех братьев члена семьи
 */

public class Command_6 implements Commands {
    ConsoleUI consoleUI;

    public Command_6(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllBrothers(str));
    }

    @Override
    public String description() {
        return "показать всех братьев члена семьи";
    }
}
