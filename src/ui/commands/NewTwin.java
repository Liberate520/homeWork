package ui.commands;

import ui.ConsoleUI;

public class NewTwin extends Command{
    public NewTwin(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать близнеца члена семьи";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().newTwin();
    }
}
