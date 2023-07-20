package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class AddGender extends Command{

    public AddGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить пол";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addGender();
    }
}
