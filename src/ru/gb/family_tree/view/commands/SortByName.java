package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class SortByName extends Command {
    public SortByName(ConsoleView consoleView) {
        super(consoleView, "сортировка по имени");
    }

    @Override
    public void execute() {
        System.out.println("сортировка по имени >>>>  \n ");
        consoleView.sortByName();
    }
}
