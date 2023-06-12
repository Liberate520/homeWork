package view.commands;

import view.Command;
import view.ConsoleUI;

import java.io.IOException;

public class PrintSortByName implements Command {
    private ConsoleUI consoleUI;

    public PrintSortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вывести данные (сорт. по имени)";
    }

    @Override
    public void execute() {
        consoleUI.printSortByName();
    }
}