package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class printFamilyTree extends Command{
    public printFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список Древа";
    }

    public void execute(){
        consoleUI.printTree();
    }
}
