package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class FinishEditMenu extends EditMenuComand {
    public FinishEditMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Back to main menu";
    }

    @Override
    public void execute(long id) {
        consoleUI.finishEditMenu();
    }
}

