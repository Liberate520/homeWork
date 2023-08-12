package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;
import ru.gb.fam_tree.view.EditMenu;

public class EditHuman extends Command{
    public EditHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Edit human";
    }

    @Override
    public void execute() {
        consoleUI.editHuman();
    }
}
