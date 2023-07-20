package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class LoadTreeFromFile extends Command{

    public LoadTreeFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить генеалогическое дерево";
    }

    public void execute() throws IOException, ClassNotFoundException {
        ConsoleUI.loadTreeFromFile();

    }
}
