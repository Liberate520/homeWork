package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class AddNewChild extends Command{


    public AddNewChild(ConsoleUI consoleUI) {
        super(consoleUI, "Определить детей");
    }
    public void execute(){
        consoleUI.addNewChildUI();
    }
}
