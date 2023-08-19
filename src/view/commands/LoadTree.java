package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command{

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить древо", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().loadTree();
    }
}
