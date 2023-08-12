package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SetBirthDate extends EditMenuComand{
    public SetBirthDate(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Change/Set birth date";
    }
    @Override
    public void execute(long id) {
        consoleUI.setBirthDate(id);
    }
}
