package vieww.comands;

import vieww.ConsoleUI;

public class GetHumanList implements Command {
    private ConsoleUI console;

    public GetHumanList(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Get human list";
    }

    public void execute(){
        console.getHumanList();
    }
}