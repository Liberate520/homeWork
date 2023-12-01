package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddDeathDate extends Command {

    public AddDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    public void execute(){
        consoleUI.addDeathdate();
    }
}
