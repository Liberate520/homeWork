package commands;

import UI.ConsoleUI;

public class ShowAllBrothers implements Commands {
    ConsoleUI consoleUI;

    public ShowAllBrothers(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllBrothers(str));
    }

    @Override
    public String description() {
        return "показать всех братьев";
    }
}