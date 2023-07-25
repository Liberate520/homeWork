package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortBYAge extends Command {
    public SortBYAge(ConsoleUI consoleUI) {
        super(consoleUI, "сортировка по возрасту");
    }

    @Override
    public void execute() {
        System.out.println("сортировка по возрасту >>>> \n ");
        consoleUI.sortByAge();
    }
}