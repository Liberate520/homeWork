package view.commands;

import view.ConsoleUI;

public class Exit extends Command{
    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выход";
    }

    @Override
    public void execute() {
        consoleUI.exit();
    }
}
