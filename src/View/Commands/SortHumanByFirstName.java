package View.Commands;

import View.ConsoleUI;

public class SortHumanByFirstName extends Command{
    public SortHumanByFirstName(ConsoleUI consoleUI){
        super("Сортировать людей по Фамилии",consoleUI);
    }
    public void execute() {
        getConsoleUI().sortByFirstName();
    }
}
