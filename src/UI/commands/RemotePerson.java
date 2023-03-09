package src.UI.commands;

import src.UI.Console;

public class RemotePerson extends Command{
    public RemotePerson(Console console){
        super(console);
    }
    @Override
    public String description() {
        return "Removing a Person from the Family Tree";
    }

    @Override
    public void execute() {
        getConsole().remotePerson();
    }
}
