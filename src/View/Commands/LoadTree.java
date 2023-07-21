package View.Commands;

import View.ConsoleUI;

public class LoadTree extends Command {

    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево из файла";
    }

    @Override
    public void execute() {
        consoleUI.loadTree();
    }
    
}
