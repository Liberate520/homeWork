package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI, "сортировка по имени");
    }

    @Override
    public void execute() {
        System.out.println("сортировка по имени >>>>  \n ");
        consoleUI.sortByName();
    }
}