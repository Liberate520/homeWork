package view.commands;

import view.ConsoleUI;

public class GetInfo extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public GetInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get information about all members of family";
    }

    public void execute(){
        getConsoleUI().getFamilyInfo();
    }

    public String getDescription(){
        return description;
    }
}
