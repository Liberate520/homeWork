package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class SortByAge extends  Command{
    public SortByAge(ConsoleUI consoleUI){
        super("Sort family tree by age", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
