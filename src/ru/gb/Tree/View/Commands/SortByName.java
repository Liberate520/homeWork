package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по имени");
    }
    public void execute(){
        consoleUI.sortByName();
    }
}
