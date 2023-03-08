package src.UI.commands;

import src.UI.Console;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Load FamilyTree object from the file";
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
