package ui.commands;

import ui.Console;

public class SearchParents extends Command{
    public SearchParents (Console console)  {
        super(console);
        description = "Найти родителей";
    }
    @Override
    public void execute() {
        console.searchParents ();
    }
}