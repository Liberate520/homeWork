package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class SortByBirthDate extends Command{
    public SortByBirthDate(ConsoleUI consoleUI){
        super("Sort family tree by birth date", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
    }
}
