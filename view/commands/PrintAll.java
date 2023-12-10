package view.commands;

import view.ConsoleUI;

public class PrintAll extends Command {
    public PrintAll(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать всех";
    }

    public void execute() {
        consoleUI.PrintAll();
    }

}