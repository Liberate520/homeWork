package View.commands;

import View.ConsoleUI;

public class GetInfoFamily extends Command {
    public GetInfoFamily(ConsoleUI consoleUI) {
        super("Показать всех членов семьи", consoleUI);
    }

    public void execute() {
        getConsoleUI().getInfo();
    }
}