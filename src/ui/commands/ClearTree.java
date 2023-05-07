package ui.commands;

import ui.Console;

public class ClearTree extends Command{
    public ClearTree(Console console) {
        super(console);
        description = "Очистить дерево";
    }

    @Override
    public void execute() {
        console.clearTree();
    }
}