package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class addFamilyConnections extends Command {
    public addFamilyConnections(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить семейные связи Родитель-Ребенок по ID";
    }
    public void execute(){
        consoleUI.createFamilyConnectionByID();
    }
}
