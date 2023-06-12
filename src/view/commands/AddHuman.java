package view.commands;

import view.ConsoleUI;

public class AddHuman implements Command {
    private ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить запись в фамильное дерево";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
