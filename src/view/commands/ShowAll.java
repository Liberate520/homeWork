package view.commands;

import view.ConsoleUI;

public class ShowAll extends Command{

    public ShowAll(ConsoleUI consoleUI) {
        super("Показать всех добавленных людей", consoleUI);
    }

    @Override
    public void execute() {
    getConsoleUI().showAll();
    }
}
