package view.commands;

import view.ConsoleUI;

public class AddChild extends Command{
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add child.";
    }

    public void execute(){
        consoleUI.addChild();
    }
}