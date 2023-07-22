package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по имени";
    }
    @Override
    public void execute() {
        console.sortByName();
    }
}
