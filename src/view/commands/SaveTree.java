package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить изменения в дереве";
    }

    public void execute(){
        consoleUI.saveTree();
    }
}
