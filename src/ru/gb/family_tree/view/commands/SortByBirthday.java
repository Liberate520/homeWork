package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthday extends Command {
    public SortByBirthday (ConsoleUI consoleUI) {
        super(consoleUI, "сортировка по дате рождения");
    }
    @Override
    public void execute() {
        System.out.println("сортировка по дате рождения >>>>  \n ");
        consoleUI.sortByBirthday();
    }
}