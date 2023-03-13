package ui.commands.components;

import ui.Console;
import ui.commands.Command;

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
