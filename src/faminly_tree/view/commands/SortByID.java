package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class SortByID extends Command{
    public SortByID(ConsoleUI console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по id";
    }

    @Override
    public void execute() {
        console.sortByID();
    }
}
