package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class sortByAge extends Command {
    public sortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать Список Древа по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}