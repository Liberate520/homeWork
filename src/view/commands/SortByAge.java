package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать по возрасту", consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByAge();
    }
}
