package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class sortByName extends Command {
    public sortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать Список Древа по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}