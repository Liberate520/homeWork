package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class ImportToFile extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public ImportToFile(ConsoleUI consoleUI) {
        super("загрузить дерево из файла", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().importToFile();

    }
}
