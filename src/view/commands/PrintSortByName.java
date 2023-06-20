package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class PrintSortByName implements Command {
    private ConsoleUI consoleUI;

    public PrintSortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Отсортировать по имени";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.printSortByName();
    }
}