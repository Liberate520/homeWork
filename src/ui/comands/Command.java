package ui.comands;

import ui.Console;

public abstract class Command implements Option{
    private Console console;
    String description;

    public Command(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return description;
    }

    public Console getConsole(){
        return console;
    }
    public abstract boolean execute();
}
