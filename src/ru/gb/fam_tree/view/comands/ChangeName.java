package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class ChangeName extends EditMenuComand{
    public ChangeName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Change human name";
    }


    public void execute(long id) {
        consoleUI.ChangeName(id);
    }
}
