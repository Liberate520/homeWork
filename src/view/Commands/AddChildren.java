package view.Commands;

import view.ConsoleUI;

public class AddChildren extends Commands{
    AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить детей";
    }

    @Override
    public void execute() { this.consoleUI.addChildren(); }
}
