package ui.commands;

import ui.Console;

public class AddParents extends Command {
    public AddParents(Console console){
        super(console);
    }

    @Override
    public String description() {
        return "Установить родственные связи";
    }

    @Override
    public void execute() {
        getConsole().addParents();
    }
}
