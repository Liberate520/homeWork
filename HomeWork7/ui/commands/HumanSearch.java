package HomeWork7.ui.commands;

import HomeWork7.ui.Console;

public class HumanSearch extends Command 
{
    public HumanSearch(Console console) 
    {
        super(console);
    }

    @Override
    public String description() 
    {
        return "Поиск человека по имени. ";
    }

    @Override
    public void execute() 
    {
        getConsole().humanSearch();
    }
}
