package tree.view.commands;

import tree.view.ConsoleUI;

public class GetFromConsoleHuman implements Command {
    private ConsoleUI consoleUI;

    public GetFromConsoleHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Вывести информацию по имени человека";
    }

    @Override
    public void execute() {
        consoleUI.getFromConsoleHuman();
    }
}
