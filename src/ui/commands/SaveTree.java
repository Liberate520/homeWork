package ui.commands;

import ui.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI console) {
        super(console);
        description = "Загрузить дерево из файла";
    }

    @Override
    public void execute() {
        console.saveTree();
    }
}
