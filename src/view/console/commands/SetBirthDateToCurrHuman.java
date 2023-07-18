package view.console.commands;

import view.console.ConsoleUI;

public class SetBirthDateToCurrHuman extends Command {
    public SetBirthDateToCurrHuman(ConsoleUI consoleUI) {
        super("установить текущему человеку дату рождения", consoleUI);
    }

    public void execute() {
        consoleUI.setBirthDateToCurrHuman();
    }
}