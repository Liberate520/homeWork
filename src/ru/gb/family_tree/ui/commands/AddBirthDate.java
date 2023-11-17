package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class AddBirthDate extends Command {

    public AddBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату рождения";
    }

    public void execute(){
        consoleUI.addBirthdate();
    }
}