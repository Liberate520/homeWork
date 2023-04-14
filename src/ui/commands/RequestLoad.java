package ui.commands;

import ui.ConsoleUI;

public class RequestLoad extends Command {
    public RequestLoad(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить существующие генеалогические деревья";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestLoad();
    }
}
