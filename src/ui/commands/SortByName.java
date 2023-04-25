package ui.commands;

import ui.Console;

public class SortByName extends Command {
    public SortByName(Console console){
        super(console);
    }
    public String getDescription(){
        return "Отсортировать людей по имени";
    }
    public void execute() {
        getConsole().sortByName();
    }
}
