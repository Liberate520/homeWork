package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class DeletePerson extends Command {

    public DeletePerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Delete Person;";
    }

    @Override
    public void execute() {
        getConsole().deletePerson();
    }
    
}
