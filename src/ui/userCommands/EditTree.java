package ui.userCommands;

import ui.ConsoleUI;

public class EditTree extends Command {
    public EditTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Редактировать дерево";
    }

    @Override
    public boolean execute() {
        getConsoleUI().requestEdit();
        return true;
    }
}
