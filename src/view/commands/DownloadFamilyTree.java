package view.commands;

import view.ConsoleUI;

public class DownloadFamilyTree extends Command{
    public DownloadFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить сохраненное семейное дерево";
    }

    public void execute(){
        consoleUI.downloadFamilyTree();
    }
}
