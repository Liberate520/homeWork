package View.commands;

import View.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Закончить работу", consoleUI);
    }

    public void execute() {
        getConsoleUI().exit();
    }
}