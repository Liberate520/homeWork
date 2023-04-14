package ui.commands;

import ui.Console;

public class TreeList extends Command{
    public TreeList(Console console) {
        super(console);
    }

    @Override
    public String description() {return "Семейное древо";}

    @Override
    public void execute() {
        getConsole().treeList();

    }
}
