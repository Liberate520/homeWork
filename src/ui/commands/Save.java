package ui.commands;

import ui.Console;

public class Save extends Command {
    public Save(Console console){
        super(console);
    }
    
    @Override
    public String description() {
        return "Сохранить древо";
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}
