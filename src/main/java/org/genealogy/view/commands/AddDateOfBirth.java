package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

public class AddDateOfBirth extends Command {

    public AddDateOfBirth(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату рождения";
    }

    public void execute() {
        consoleUI.addDateOfBirth();
    }
}
