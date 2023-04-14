package ui.commands;

import ui.ConsoleUI;

public class RequestEdit extends Command {
    public RequestEdit(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Редактировать существующее генеалогическое древо";
    }

    @Override
    public boolean execute() {
        getConsoleUI().requestEdit();
        return true;
    }
}
