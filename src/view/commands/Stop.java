package view.commands;

import view.ConsoleUI;

public class Stop implements Command {
    private ConsoleUI consoleUI;

    public Stop(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из приложения";
    }

    @Override
    public void execute() {
        consoleUI.stop();
    }
}
