package view.commands;

import view.ConsoleUI;

public class OpenSaveTree extends Command{
    public OpenSaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Открыть сохранения в дереве";
    }

    public void execute(){
        consoleUI.openSaveTree();
    }
}
