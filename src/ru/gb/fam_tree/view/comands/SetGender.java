package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetGender extends EditMenuComand{
    public SetGender(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Change gender";
    }
    @Override
    public void execute(long id) {
        consoleUI.setGender(id);
    }
}
