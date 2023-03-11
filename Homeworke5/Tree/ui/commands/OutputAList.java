package ui.commands;

import ui.Console;

public class OutputAList extends Command {

    public OutputAList(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Output the entire list;";
    }

    @Override
    public void execute() {
        getConsole().printList();
    }
    
}
