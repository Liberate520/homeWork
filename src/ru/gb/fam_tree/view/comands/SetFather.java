package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetFather extends EditMenuComand{
    public SetFather(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Set father";
    }
    @Override
    public void execute(long id) {
        consoleUI.setFather(id);
    }
}
