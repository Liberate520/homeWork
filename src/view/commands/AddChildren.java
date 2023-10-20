package view.commands;

import view.ConsoleUI;

public class AddChildren extends Command{
    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить детей";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute() {
        consoleUI.addChildren();


    }
}
