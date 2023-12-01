package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add human.";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}
