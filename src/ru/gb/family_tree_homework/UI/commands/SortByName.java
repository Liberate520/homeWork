package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super("Sort family tree by name", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
