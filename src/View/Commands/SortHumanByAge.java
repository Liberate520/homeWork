package View.Commands;

import View.ConsoleUI;

public class SortHumanByAge extends Command{
    public SortHumanByAge(ConsoleUI consoleUI){
        super("Сортировать людей по Возрасту",consoleUI);
    }
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
