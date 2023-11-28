package view.commands;

import view.ConsoleUI;

public class SortByChildren extends Command {
    public SortByChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по количеству детей";
    }

    public void execute(){
        consoleUI.sortByChildren();
    }
}