package view.command;

import view.ConsoleUI;

public class FamilyGetInfo extends Command {
    public FamilyGetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.getInfo();
    }
}