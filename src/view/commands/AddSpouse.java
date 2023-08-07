package view.commands;

import view.ConsoleUI;

public class AddSpouse extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Make marrige couple between persons";
    }

    public void execute(){
        getConsoleUI().addSpouse();
    }

    public String getDescription(){
        return description;
    }


}
