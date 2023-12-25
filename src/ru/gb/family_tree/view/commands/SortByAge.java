package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class SortByAge extends Command {
    public SortByAge(Console console) {
        super("Sort the family tree by age", console);
    }

    public void execute() {
        getConsole().sortByAge();
    }
}
