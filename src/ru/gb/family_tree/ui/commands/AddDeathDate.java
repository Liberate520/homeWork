package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class AddDeathDate extends Command {

    public AddDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    public void execute(){
        consoleUI.addDeathdate();
    }
}
