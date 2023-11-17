package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по возрасту";
    }

    public void execute(){
        consoleUI.sortAge();
    }
}
