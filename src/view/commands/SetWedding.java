package view.commands;

import view.ConsoleUI;

public class SetWedding extends Command {

    public SetWedding(ConsoleUI consoleUI) {
        super("Set Wedding", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().setWedding();
    }
}
