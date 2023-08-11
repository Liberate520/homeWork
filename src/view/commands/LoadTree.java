package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command{
    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить древо";
    }

    @Override
    public void execute() {
        consoleUI.loadTree();
    }
}
