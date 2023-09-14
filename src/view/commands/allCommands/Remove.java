package view.commands.allCommands;

import view.ConsoleUI;

public class Remove extends Command{
    public Remove(ConsoleUI consoleUI) {
        super("Remove item by ID", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().remove();
    }
}