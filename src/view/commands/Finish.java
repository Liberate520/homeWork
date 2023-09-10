package view.commands;

import view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Goodbye!", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().finish();
    }
}