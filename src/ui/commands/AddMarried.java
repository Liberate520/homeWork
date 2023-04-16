package ui.commands;

import ui.ConsoleUI;

public class AddMarried extends Command{
    public AddMarried(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Связать в качестве мужа/жены одного члена семьи с другим членом семьи (для людей)";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().addMarried();
    }
}
