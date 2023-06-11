package view.menu.commands;

import view.ConsoleUI;

public class AddRecord implements Command {
    private ConsoleUI consoleUI;

    public AddRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавить запись в древо";
    }

    @Override
    public void execute() {
        consoleUI.addRecordInTree();
    }
}
