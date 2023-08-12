package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public abstract class EditMenuComand {
    String description;
    ConsoleUI consoleUI;

    public EditMenuComand(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(long id);
}
