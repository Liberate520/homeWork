package view.console.commands;

import view.console.ConsoleUI;

public class SetDeathDateToCurrHuman extends Command {
    public SetDeathDateToCurrHuman(ConsoleUI consoleUI) {
        super("установить текущему человеку дату смерти", consoleUI);
    }

    public void execute() {
        consoleUI.setDeathDateToCurrHuman();
    }
}