package view.commands;

import view.ConsoleUI;

public class Sorts extends Command{

    public Sorts(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список";
    }

    public void execute(){
        consoleUI.sortmenu();
    }
}