package ui.commands;

import ui.ConsoleUI;

public class ClearTree extends Command{
    public ClearTree(ConsoleUI console) {
        super(console);
        description = "Очистить дерево";
    }

    @Override
    public void execute() {
        console.clearTree();

    }
}
