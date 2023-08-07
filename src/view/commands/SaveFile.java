package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SaveFile extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public SaveFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Save changes";
    }

    public void execute() throws IOException {
        getConsoleUI().saveFile();
    }

    public String getDescription(){
        return description;
    }


}