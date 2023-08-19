package view.commands;

import view.ConsoleUI;

public class AddParent extends Command{

    public AddParent(ConsoleUI consoleUI) {
        super("Добавить родство (по id)", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addParent();
    }
}
