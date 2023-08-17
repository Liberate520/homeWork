package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetDeathDate extends EditMenuComand{
    public SetDeathDate(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Chande/Set death date";
    }
    @Override
    public void execute(long id) {

    }
}
