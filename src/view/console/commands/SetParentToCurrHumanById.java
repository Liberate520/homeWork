package view.console.commands;

import view.console.ConsoleUI;

public class SetParentToCurrHumanById extends Command {
    public SetParentToCurrHumanById(ConsoleUI consoleUI) {
        super("установить текущему человеку родителя", consoleUI);
    }

    public void execute() {
        consoleUI.setParentToCurrHumanById();
    }
}