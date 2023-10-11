package View.Commands;

import View.ConsoleUI;

public class DowbloadHumanTree extends Command{
    public DowbloadHumanTree(ConsoleUI consoleUI){
        super("Загрузить дерево",consoleUI);
    }
    public void execute() {
        getConsoleUI().readTree();
    }
}
