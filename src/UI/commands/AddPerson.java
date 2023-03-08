package src.UI.commands;

import src.UI.Console;

public class AddPerson extends Command{
    public AddPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add a Person to Family Tree";
    }

    @Override
    public void execute() {
        getConsole().addPerson();
    }
}
