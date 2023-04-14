package ui.commands;

import ui.ConsoleUI;

public class RequestSave extends Command{
    public RequestSave(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить существующие генеалогические деревья";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestSave();
    }
}
