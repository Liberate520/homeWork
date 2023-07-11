package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }
    public void execute(){
        consoleUI.addHuman();
    }
}
