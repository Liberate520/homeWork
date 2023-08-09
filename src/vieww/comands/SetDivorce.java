package vieww.comands;

import vieww.ConsoleUI;

public class SetDivorce implements Command {
    private ConsoleUI console;

    public SetDivorce(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Set divorce";
    }

    public void execute(){
        console.setDivorce();
    }
}