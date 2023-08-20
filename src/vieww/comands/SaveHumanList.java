package vieww.comands;

import vieww.ConsoleUI;

public class SaveHumanList implements Command {
    private ConsoleUI console;

    public SaveHumanList(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Save human list";
    }

    public void execute(){
        console.saveToFile();
    }
}