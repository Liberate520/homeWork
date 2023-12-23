package view.commands;

import view.ConsoleUI;

public class SetSpouce extends Command{
    public SetSpouce(ConsoleUI consoleUI) {
        super("Задать супругов", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setSpouce();
    }
}
