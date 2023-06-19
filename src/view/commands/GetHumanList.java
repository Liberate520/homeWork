package view.commands;

import view.ConsoleUI;

public class GetHumanList implements Command {
    private ConsoleUI consoleUI;

    public GetHumanList(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать фамильное дерево";
    }

    @Override
    public void execute() {
        consoleUI.getHumanList();
    }
}
