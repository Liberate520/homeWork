package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI,"Отсортировать семейный список по возрасту");
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}
