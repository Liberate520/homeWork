package ui.commands;

import ui.ConsoleUI;

public class NewMember extends Command{
    public NewMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать нового члена семьи";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().newMember();
    }
}
