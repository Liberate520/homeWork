package view.commands;

import view.ConsoleUI;

public class SetChild extends Command {
    public SetChild(ConsoleUI consoleUI) {
        super("Задать ребенка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setChild();
    }
}
