package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI console) {
        super(console);
        description = "Cортировать список по имени";
    }

    public void execute() {
        consoleUI.sortByName();
    }
}
