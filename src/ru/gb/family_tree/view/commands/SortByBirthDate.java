package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать членов дерева по дате рождения";
    }

    @Override
    public void execute() { consoleUI.sortByBirthDate(); }
}
