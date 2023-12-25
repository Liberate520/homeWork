package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command{

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
