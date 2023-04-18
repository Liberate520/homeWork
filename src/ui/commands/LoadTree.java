package ui.commands;

import ui.ConsoleUI;

public class LoadTree extends Command{

    public LoadTree(ConsoleUI console) {
        super(console);
        description = "Загрузить дерево из файла \n";
    }
    @Override
    public void execute() {
        console.loadTree();
    }
}
