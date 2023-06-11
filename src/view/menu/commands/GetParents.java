package view.menu.commands;

import view.ConsoleUI;

public class GetParents implements Command{
    private ConsoleUI consoleUI;

    public GetParents(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить родителей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getParents();

    }
}
