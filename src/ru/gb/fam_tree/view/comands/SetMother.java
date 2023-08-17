package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetMother extends EditMenuComand{
    public SetMother(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Set mother";
    }
    @Override
    public void execute(long id) {
        consoleUI.setMother(id);
    }
}
