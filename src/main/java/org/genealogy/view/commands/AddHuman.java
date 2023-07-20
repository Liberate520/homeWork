package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }
    public void execute() throws IOException {
        consoleUI.addHuman();
    }
}
