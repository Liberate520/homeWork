package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetChild extends EditMenuComand{
    public SetChild(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Add Child";
    }
    @Override
    public void execute(long id) {
        consoleUI.setChild(id);
    }
}
