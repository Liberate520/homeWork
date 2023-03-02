package ui.commands;

import ui.Console;

public class PrintTree extends Command
{
    public PrintTree(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Печать дерева";
    }

    @Override
    public void execute()
    {
        getConsole().consolePrintTree();
    }
}
