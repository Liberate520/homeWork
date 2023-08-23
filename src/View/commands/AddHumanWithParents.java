package View.commands;

import View.ConsoleUI;

public class AddHumanWithParents extends Command {
    public AddHumanWithParents(ConsoleUI consoleUI) {
        super("Добавьте человека с родителями", consoleUI);
    }
    public void execute() {
        getConsoleUI().addHumanWithParents();
    }
}
