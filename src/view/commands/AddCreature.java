package view.commands;

import view.ConsoleUI;

public class AddCreature extends Command{

    public AddCreature(ConsoleUI consoleUI) {
        super("Добавить существо", consoleUI);
    }

    public void execute(){
        getConsoleUI().addCreature();
    }
}
