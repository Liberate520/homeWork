package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class File  extends Command {
    public File(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Работа с файлом";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.file();
    }
}

