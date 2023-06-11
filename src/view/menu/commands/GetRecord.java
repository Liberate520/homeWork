package view.menu.commands;

import view.ConsoleUI;

public class GetRecord implements Command {
    private ConsoleUI consoleUI;

    public GetRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить запись из древа";
    }

    @Override
    public void execute() {
        consoleUI.getRecordInTree();
    }
}
