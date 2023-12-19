package view.commands;

import view.ConsoleUI;

public class SortByFamilyName extends Command{
    public SortByFamilyName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать список людей по фамилии.";
    }

    @Override
    public void execute() {
        consoleUI.sortByFamilyName();
    }
}
