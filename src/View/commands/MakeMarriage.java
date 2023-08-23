package View.commands;

import View.ConsoleUI;

public class MakeMarriage extends Command {
    public MakeMarriage(ConsoleUI consoleUI) {
        super("Сыграть свадьбу", consoleUI);
    }
    public void execute() {
        getConsoleUI().makeMarriage();
    }
}
