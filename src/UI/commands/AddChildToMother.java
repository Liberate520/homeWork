package src.UI.commands;

import src.UI.Console;

public class AddChildToMother extends Command{
    public AddChildToMother(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add a son to the Mother Person";
    }

    @Override
    public void execute() {
        getConsole().addChildToMother();
    }

}
