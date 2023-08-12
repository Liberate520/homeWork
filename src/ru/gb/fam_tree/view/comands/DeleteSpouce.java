package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class DeleteSpouce extends EditMenuComand{
    public DeleteSpouce(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Delete Spouce";
    }
    @Override
    public void execute(long id) {
        consoleUI.setDivorce(id);
    }
}
