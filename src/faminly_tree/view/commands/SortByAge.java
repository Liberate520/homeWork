package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI console) {
        super(console);
        description = "Отсортировать всех людей в семеном древе по возрасту";
    }

    @Override
    public void execute() {
        console.sortByAge();
    }
}