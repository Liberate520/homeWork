package tree.view.commands;

import tree.view.ConsoleUI;

public class AddFromConsoleHuman implements Command {
    private ConsoleUI consoleUI;

    public AddFromConsoleHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.addFromConsoleHuman();
    }
}
