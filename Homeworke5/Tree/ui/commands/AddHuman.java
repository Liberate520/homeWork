package ui.commands;

import ui.Console;

public class AddHuman extends Command {

    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add a new person;";
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }
    
}
