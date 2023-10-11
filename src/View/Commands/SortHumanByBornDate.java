package View.Commands;

import View.ConsoleUI;

public class SortHumanByBornDate extends Command{
    public SortHumanByBornDate(ConsoleUI consoleUI){
        super("Сортировать людей по Дате Рождения",consoleUI);
    }
    public void execute() {
        getConsoleUI().sortByBornDate();
    }
}
