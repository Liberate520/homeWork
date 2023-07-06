package tree.view.commands;

import tree.view.ConsoleUI;

public class GetFromConsoleAllHuman implements Command{
    private ConsoleUI consoleUI;

    public GetFromConsoleAllHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вывести всех людей";
    }

    @Override
    public void execute() {
        consoleUI.getFromConsoleAllHuman();
    }
}
