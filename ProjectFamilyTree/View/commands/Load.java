package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

import java.io.IOException;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super("Загрузить дерево", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        super.consoleUI.Load();
    }
}
