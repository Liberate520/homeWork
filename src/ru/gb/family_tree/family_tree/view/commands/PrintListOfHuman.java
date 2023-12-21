package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class PrintListOfHuman extends Command{
    public PrintListOfHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список Древа";
    }

    public void execute(){
        consoleUI.PrintTree();
    }
}
