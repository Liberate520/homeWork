package ui.commands;

import ui.Console;

public class AddTargarien extends Command{
    public AddTargarien(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Add Targariens to list";
    }

    @Override
    public void execute() {
        getConsole().getTreeInfo();
    }
}
