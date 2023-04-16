package ui.userCommands;

import ui.ConsoleUI;

public class CreateSample extends Command{
    public CreateSample(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить нового представителя семейного дерева";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().newMember();
    }
}
