package view.commands;

import view.ConsoleUI;

public class Finish extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        super("", consoleUI);

    }

    public void execute(){
        getConsoleUI().finish();
    }

    public String getDescription(){
        return description;
    }
}
