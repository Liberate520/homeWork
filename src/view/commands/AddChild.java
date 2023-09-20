package view.commands;

import view.ConsoleUI;

public class AddChild extends Command {

    public AddChild(ConsoleUI consoleUI) {
        super("Add child", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().addChild();
    }
}