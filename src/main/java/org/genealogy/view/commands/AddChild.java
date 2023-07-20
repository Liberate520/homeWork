package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.addChild();
    }
}
