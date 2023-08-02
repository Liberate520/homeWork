package View.commands;

import View.ConsoleUI;

public class Load extends Command {
    public Load(ConsoleUI consoleUI) {
        super("Загрузить изменения", consoleUI);
    }
    public void execute() {
        getConsoleUI().load();
    }
}