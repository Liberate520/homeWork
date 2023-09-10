package view.commands;

import view.ConsoleUI;

public class GetById extends Command{
    public GetById(ConsoleUI consoleUI) {
        super("Search item by ID", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().getById();
    }
}