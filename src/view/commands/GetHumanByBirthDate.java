package view.commands;

import view.ConsoleUI;

public class GetHumanByBirthDate implements Command {
    private ConsoleUI consoleUI;

    public GetHumanByBirthDate(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Найти человека по году рождения";
    }

    @Override
    public void execute() {
        consoleUI.getHumanByBirthDate();
    }
}
