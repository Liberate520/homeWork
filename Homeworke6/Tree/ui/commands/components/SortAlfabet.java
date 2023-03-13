package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class SortAlfabet extends Command{

    public SortAlfabet(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Sort alphabetically;";
    }

    @Override
    public void execute() {
        getConsole().sortAlfab();
    }
    
}
