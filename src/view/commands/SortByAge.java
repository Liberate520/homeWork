package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по возрасту.";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }
}
