package home_work.view.command;

import home_work.view.ConsoleUI;

/**
 * AddHuman
 */
public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
        
    }

    public void execute() {
        super.getConsoleUI().addHuman();
    }
}