package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать список по возрасту");

    }

    public void execute(){
        consoleUI.sortByAge();
    }

}
