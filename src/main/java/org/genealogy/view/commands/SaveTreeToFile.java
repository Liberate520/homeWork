package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

import java.io.IOException;

public class SaveTreeToFile extends Command{

    public SaveTreeToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить генеалогическое дерево";
    }

    public void execute() throws IOException {
        ConsoleUI.saveTreeToFile();
    }
}
