package view.commands;

import view.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по гендеру";
    }

    public void execute(){
        consoleUI.sortByGender();
    }
}