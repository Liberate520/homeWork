package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
