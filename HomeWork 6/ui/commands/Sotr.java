package HomeWork5.ui.commands;

import HomeWork5.ui.Console;

public class Sotr extends Command
{

    public Sotr(Console console) 
    {
        super(console);
    }

    @Override
    public String description() 
    {
        return "Сортировка семейного дерева. ";
    }

    @Override
    public void execute() 
    {
        getConsole().sortFamily();     
    }
    
}
