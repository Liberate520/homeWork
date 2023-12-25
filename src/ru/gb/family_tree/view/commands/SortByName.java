package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class SortByName extends Command {
    public SortByName(Console console) {
        super("Sort the family tree by name", console);
    }

    public void execute() {
        getConsole().sortByName();
    }
}
