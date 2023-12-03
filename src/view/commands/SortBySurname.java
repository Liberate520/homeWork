package view.commands;

import view.ConsoleUI;

public class SortBySurname extends Command {
    public SortBySurname(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по фамилии";
    }

    public void execute(){
        consoleUI.sortBySurname();
    }
}
