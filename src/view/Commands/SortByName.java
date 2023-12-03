package view.Commands;

import view.ConsoleUI;

public class SortByName extends Commands{
    SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по имени";
    }

    @Override
    public void execute() {
        this.consoleUI.sortByName();
    }
}
