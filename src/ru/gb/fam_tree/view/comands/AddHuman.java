package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Add a new member";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
