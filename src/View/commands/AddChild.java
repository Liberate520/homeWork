package View.commands;

import View.ConsoleUI;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super("Добавьте ребёнка родителям", consoleUI);
    }
    public void execute() {
        getConsoleUI().addChild();
    }
}
