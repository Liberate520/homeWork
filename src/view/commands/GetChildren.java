package view.commands;

import view.ConsoleUI;

public class GetChildren extends Command{
    public GetChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Список всех детей человека.";
    }

    @Override
    public void execute() {
        consoleUI.getChildren();
    }
}
