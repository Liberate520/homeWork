package FT.commands;

import FT.UI.ConsoleUI;

public class ShowAllSisters implements Commands {
    ConsoleUI consoleUI;

    public ShowAllSisters(ConsoleUI consoleUI) {
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