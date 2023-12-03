package view.command;

import view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI console) {
        super(console);
        description = "Отсортировать список по имени";
    }
    public void execute(){
            console.sortByName();
        }
}
