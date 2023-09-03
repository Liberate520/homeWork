package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class ExportFromFile extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public ExportFromFile(ConsoleUI consoleUI) {
        super("выгрузить дерево в файл", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().exportFromFile();
    }
}
