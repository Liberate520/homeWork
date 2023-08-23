package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

import java.io.IOException;

public class Save extends Command{
    public Save(ConsoleUI consoleUI) {
        super("Сохранить дерево", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.consoleUI.Save();
    }
}
