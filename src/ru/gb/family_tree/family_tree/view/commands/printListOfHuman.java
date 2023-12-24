package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class printListOfHuman extends Command{
    public printListOfHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список Древа";
    }

    public void execute(){
        consoleUI.printTree();
    }
}
