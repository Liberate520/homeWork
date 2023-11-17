package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class GetTree extends Command {

    public GetTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Просмотреть весь список";
    }

    public void execute(){
        consoleUI.viewAll();
    }
}
