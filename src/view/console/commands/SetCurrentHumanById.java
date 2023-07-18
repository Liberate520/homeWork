package view.console.commands;

import view.console.ConsoleUI;

public class SetCurrentHumanById extends Command {
    public SetCurrentHumanById(ConsoleUI consoleUI) {
        super("выбрать текущего человека по id", consoleUI);
    }

    public void execute() {
        consoleUI.setCurrentHumanById();
    }
}