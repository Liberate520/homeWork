package vieww.comands;

import vieww.ConsoleUI;

public class PrintHumanList implements Command {
    private ConsoleUI console;

    public PrintHumanList(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Print human list";
    }

    public void execute(){
        console.getHumanList();
    }
}