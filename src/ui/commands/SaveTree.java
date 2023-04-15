package ui.commands;

import ui.ConsoleUI;

public class SaveTree extends Command{
    public SaveTree(ConsoleUI console) {
        super(console);
        description = "Сохранить дерево в файл \n";
    }

    @Override
    public void execute() {
        console.saveTree();
    }
}
