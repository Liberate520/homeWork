package view.commands;

import view.ConsoleUI;

public class AddChildren extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Adding child to person";
    }

    public void execute(){
        getConsoleUI().addChildren();
    }

    public String getDescription(){
        return description;
    }


}
