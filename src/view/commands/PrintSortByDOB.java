package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class PrintSortByDOB implements Command {
    private ConsoleUI consoleUI;

    public PrintSortByDOB(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.printSortByDOB();
    }
}