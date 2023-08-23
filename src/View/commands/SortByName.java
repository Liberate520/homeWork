package View.commands;

import View.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }
    public void execute(){
        getConsoleUI().sortByName();
    }
}
