package FamilyTree.View.commands.FileCommanda;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

import java.io.IOException;

public class Load  extends Command {
    public Load (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево с диска";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.load();
    }
}