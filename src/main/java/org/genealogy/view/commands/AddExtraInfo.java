package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class AddExtraInfo extends Command{
    public AddExtraInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дополнительную информацию";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addExtraInfo();
    }
}
