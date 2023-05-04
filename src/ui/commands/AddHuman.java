package ui.commands;

import ui.Console;

public class AddHuman implements Command {
    Console console;

    public AddHuman(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
       console.addHuman();
        
    }

    @Override
    public String getDescription() {
                return "Добавить человека в дерево";
    }
    
}
