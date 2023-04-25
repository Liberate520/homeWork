package ui.commands;

import ui.Console;

public class SortByBirthDay extends Command{

    public SortByBirthDay(Console console){
        super(console);
    }
    public String getDescription(){
        return "Отсортировать людей по дню рождения";
    }

    public void execute() {
        getConsole().sortByBirthDay();
    }
}
