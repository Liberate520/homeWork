package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class AddDateOfDeath extends Command{

    public AddDateOfDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addDateOfDeath();
    }
}
