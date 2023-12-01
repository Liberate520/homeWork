package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddBirthDate extends Command {

    public AddBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату рождения";
    }

    public void execute(){
        consoleUI.addBirthdate();
    }
}