package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class addHuman extends Command{

    public addHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}
