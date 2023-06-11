package view.menu.commands;

import view.ConsoleUI;

public class GetAllRecord implements Command {

    private ConsoleUI consoleUI;

    public GetAllRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать все записи в древе";
    }

    @Override
    public void execute() {
        consoleUI.getAllRecord();

    }
}
