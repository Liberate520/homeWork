package ui.commands;

import ui.Console;

public class SearchChild extends Command{
    public SearchChild (Console console)  {
        super(console);
        description = "Найти детей";
    }
    @Override
    public void execute() {
        console.searchChild ();
    }
}
