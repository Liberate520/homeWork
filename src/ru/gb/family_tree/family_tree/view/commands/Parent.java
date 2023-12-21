package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class Parent extends Command {
    public Parent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя";
    }
    public void execute(){
        consoleUI.addParent();
    }
}
