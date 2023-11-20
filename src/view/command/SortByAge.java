package view.command;

import view.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI console) {
        super(console);
        description = "Отсортировать список по возрасту";
    }

    public void execute(){
        console.sortByAge();
    }
}