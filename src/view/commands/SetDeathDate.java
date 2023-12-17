package view.commands;

import view.ConsoleUI;

public class SetDeathDate extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super("Задать дату смерти человека", consoleUI);
    }

    @Override
    public void execute() { getConsoleUI().setDeathDate();
    }
}