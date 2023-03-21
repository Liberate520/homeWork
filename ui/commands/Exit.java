package ui.commands;

import ui.Console;

import javax.swing.text.View;

public class Exit extends Command {
    
    public Exit(ui.Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Закрыть консоль";
    }

    @Override
    public void execute() {
        getConsole().finish();        
    }
}
