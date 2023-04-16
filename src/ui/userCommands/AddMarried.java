package ui.userCommands;

import ui.ConsoleUI;

public class AddMarried extends Command{
    public AddMarried(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить мужа или жену ";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().addMarried();
    }
}
