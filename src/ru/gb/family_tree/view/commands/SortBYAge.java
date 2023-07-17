package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class SortBYAge extends Command {
    public SortBYAge (ConsoleView consoleView) {
        super(consoleView, "сортировка по возрасту");
    }

    @Override
    public void execute() {
        System.out.println("сортировка по возрасту >>>> \n ");
        consoleView.sortByAge();
    }
}
