package HomeWork5.ui.commands;

import HomeWork5.ui.Console;

public class HumanSearch extends Command 
{
    public HumanSearch(Console console) 
    {
        super(console);
    }

    @Override
    public String description() 
    {
        return "Поиск человека по именни. ";
    }

    @Override
    public void execute() 
    {
        getConsole().humanSearch();
    }
}
