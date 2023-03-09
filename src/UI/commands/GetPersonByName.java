package src.UI.commands;

import src.UI.Console;

public class GetPersonByName extends Command{
    public GetPersonByName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Find a person by name";
    }

    @Override
    public void execute() {
        getConsole().getPersonByName();
    }
}