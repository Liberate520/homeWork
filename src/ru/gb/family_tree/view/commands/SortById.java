package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortById extends Command {

    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по Id";
    }

    public void execute(){
        consoleUI.sortId();
    }
}

