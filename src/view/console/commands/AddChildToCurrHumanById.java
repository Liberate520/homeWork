package view.console.commands;

import view.console.ConsoleUI;

public class AddChildToCurrHumanById extends Command {
    public AddChildToCurrHumanById(ConsoleUI consoleUI) {
        super("добавить текущему человеку ребёнка", consoleUI);
    }

    public void execute() {
        consoleUI.addChildToCurrHumanById();
    }
}