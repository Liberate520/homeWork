package ui.commands;

import ui.Console;

public class SetFemale implements Command{
    Console console;

    public SetFemale(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.SetFemale();
        
    }

    @Override
    public String getDescription() {
        return "Женский";
    }  
    
}
