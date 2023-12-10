package view.commands;

import view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать всех";
    }

    public void execute() {
        consoleUI.finish();
    }

}