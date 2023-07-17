package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class SortByBirthday extends Command {
    public SortByBirthday (ConsoleView consoleView) {
        super(consoleView, "сортировка по дате рождения");
    }
    @Override
    public void execute() {
        System.out.println("сортировка по дате рождения >>>>  \n ");
        consoleView.sortByBirthday();
    }
}
