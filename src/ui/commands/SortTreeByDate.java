package ui.commands;

import ui.Console;

public class SortTreeByDate extends Command
{
    public SortTreeByDate(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Отсортировать дерево по датам рождения";
    }

    @Override
    public void execute()
    {
        getConsole().consoleSortTreeByDate();
    }
}
