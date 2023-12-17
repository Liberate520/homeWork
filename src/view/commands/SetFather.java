package view.commands;

import view.ConsoleUI;

public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI) {
        super("Задать отца", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setFather();
    }
}
