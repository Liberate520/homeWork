package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class SortByLastname extends Command {

    public SortByLastname(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по фамилии";
    }

    public void execute(){
        consoleUI.sortLastname();
    }
}
