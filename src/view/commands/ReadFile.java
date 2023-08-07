package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class ReadFile extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Read existing file";
    }

    public void execute() throws IOException {
        getConsoleUI().readFile();
    }

    public String getDescription(){
        return description;
    }


}
