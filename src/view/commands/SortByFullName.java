package view.commands;

import view.ConsoleUI;

public class SortByFullName extends Command {
    public SortByFullName(ConsoleUI consoleUI) {
        super(consoleUI,"Отсортировать семейный список по ФИО");
    }

    public void execute(){
        consoleUI.sortByFullName();
    }
}
