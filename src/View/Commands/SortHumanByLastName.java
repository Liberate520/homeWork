package View.Commands;

import View.ConsoleUI;

public class SortHumanByLastName extends Command{
    public SortHumanByLastName(ConsoleUI consoleUI){
        super("Сортировать людей по Имени",consoleUI);
    }
    public void execute() {
        getConsoleUI().sortByLastName();
    }
}
