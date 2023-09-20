package view.commands;

import view.ConsoleUI;

public class SetDivorce extends Command {

    public SetDivorce(ConsoleUI consoleUI) {
        super("Set divorce", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setDivorce();
    }
}

