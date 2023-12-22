package view.commands;

import view.ConsoleUI;

public class ShowAllInfo extends Command{
    public ShowAllInfo(ConsoleUI consoleUI) {
        super("Показать подробную информацию о человеке", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().ShowAllInfo();
    }
}
