package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddPerson(ConsoleUI consoleUI) {
        super("Add human to family", consoleUI);
    }

    public void execute(){
        getConsoleUI().addPerson();
    }

    public String getDescription(){
        return description;
    }


}
