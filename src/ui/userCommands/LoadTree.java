package ui.userCommands;

import ui.ConsoleUI;

public class LoadTree extends Command {
    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить дерево";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestLoad();
    }
}
