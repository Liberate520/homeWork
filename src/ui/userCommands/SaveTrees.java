package ui.userCommands;

import ui.ConsoleUI;

public class SaveTrees extends Command{
    public SaveTrees(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить деревья";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestSave();
    }
}
