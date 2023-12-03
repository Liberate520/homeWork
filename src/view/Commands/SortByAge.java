package view.Commands;

import view.ConsoleUI;

public class SortByAge extends Commands{

    SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по возрасту";
    }
    @Override
    public void execute() {
        this.consoleUI.sortByAge();
    }
}
