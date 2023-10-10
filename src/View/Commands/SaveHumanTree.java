package View.Commands;

import View.ConsoleUI;

public class SaveHumanTree extends Command{
    public SaveHumanTree(ConsoleUI consoleUI){
        super("Сохранить дерево",consoleUI);
    }
    public void execute() {
        getConsoleUI().saveTree();
    }
}
