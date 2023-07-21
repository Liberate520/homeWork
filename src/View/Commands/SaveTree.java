package View.Commands;

import View.ConsoleUI;

public class SaveTree extends Command {

    public SaveTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить дерево в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
    
}
