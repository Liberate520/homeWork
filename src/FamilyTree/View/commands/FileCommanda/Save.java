package FamilyTree.View.commands.FileCommanda;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

import java.io.IOException;

public class Save extends Command {
    public Save (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить дерево на диске";
    }

    public void execute() throws IOException, ClassNotFoundException {consoleUI.save();
    }
}
