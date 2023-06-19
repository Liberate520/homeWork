package view.commands;

import view.ConsoleUI;

public class GetHumanByName implements Command {
    private ConsoleUI consoleUI;

    public GetHumanByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Найти человека по имени и фамилии";
    }

    @Override
    public void execute() {
        consoleUI.getHumanByName();
    }
}
