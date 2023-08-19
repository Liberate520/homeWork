package view.commands;

import view.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByName();
    }
}
