package commands;

import UI.ConsoleUI;

public class ShowAllChildren implements Commands {
    ConsoleUI consoleUI;

    public ShowAllChildren(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllChildren(str));
    }

    @Override
    public String description() {
        return "показать всех детей";
    }
}