package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByLastname extends Command {

    public SortByLastname(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по фамилии";
    }

    public void execute(){
        consoleUI.sortLastname();
    }
}
