package view.commands;

import view.Command;
import view.ConsoleUI;

import java.io.IOException;

public class PrintSortByDOB implements Command {
    private ConsoleUI consoleUI;

    public PrintSortByDOB(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вывести данные (сорт. по дате рождения)";
    }

    @Override
    public void execute() {
        consoleUI.printSortByDOB();
    }
}