package ui.commands;

import ui.Console;  

public abstract class Command implements Option{

    private Console console;

    public Console getConsole() {
        return console;
    }

    public Command(Console console) {
        this.console = console;
    }
    
}
