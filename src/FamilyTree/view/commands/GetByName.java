package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

import java.util.Scanner;

public class GetByName implements Command {
    private ConsoleUI consoleUI;

    public GetByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Поиск по имени";
    }

    @Override
    public void execute() {
        consoleUI.getByName();
    }
}
