package view.commands;

import view.Console;

public class SortByName extends Command{
    
    public SortByName(Console console) {
        super(console);
        description = "Сортировка по имени";
    }

    @Override
    public void execute() {
        console.sortByName();
    }
}
