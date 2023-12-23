package view.commands;

import view.ConsoleUI;

public class SetDivorce extends Command{
    public SetDivorce(ConsoleUI consoleUI) {
        super("Развести супругов", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetDivorce();
    }
}
