package view.commands;

import view.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать связь родитель-ребенок";
    }
    @Override
    public void execute() {
        consoleUI.addChild();
    }
}
