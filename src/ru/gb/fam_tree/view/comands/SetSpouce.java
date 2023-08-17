package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetSpouce extends EditMenuComand{
    public SetSpouce(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Set Spouce";
    }

    @Override
    public void execute(long id) {
        consoleUI.setWedding(id);
    }
}
