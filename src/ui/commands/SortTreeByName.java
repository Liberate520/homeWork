package ui.commands;

import ui.Console;

public class SortTreeByName extends Command
{
    public SortTreeByName(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Отсортировать дерево по именам";
    }

    @Override
    public void execute()
    {
        getConsole().consoleSortTreeByName();
    }
}
