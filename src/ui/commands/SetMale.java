package ui.commands;

import ui.Console;

public class SetMale implements Command {
    Console console;

    public SetMale(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.SetMale();
        
    }

    @Override
    public String getDescription() {
        return "Мужской";
    }


    
    
}
