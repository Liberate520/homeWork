package view.commands;

import view.Console;

public class SortByAge extends Command {

    public SortByAge(Console console) {
        super(console);
        description = "Сортировка по возрасту";
    }

    @Override
    public void execute() {
        console.sortByAge();
    }
    
}
