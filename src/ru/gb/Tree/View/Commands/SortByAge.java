package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по возрасту");
    }
    public void execute(){
        consoleUI.sortByAgeUI();
    }
}
