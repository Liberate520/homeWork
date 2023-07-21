package ui.userCommands;

import ui.ConsoleUI;

public class CreateTree extends Command {
    public CreateTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать новое дерево";
    }

    @Override
    public boolean execute() {
        getConsoleUI().newFTree();
        return true;
    }
}
