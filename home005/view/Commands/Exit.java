package view.Commands;

import view.Console;

public class Exit extends Command{
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String act() {
        return "Exit";
    }

    public void execute() {
        getConsole().exit();
    }
    
}
