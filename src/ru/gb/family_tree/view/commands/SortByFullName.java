package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByFullName extends Command {
    public SortByFullName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка семейного дерева по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByFullName();
    }
}
