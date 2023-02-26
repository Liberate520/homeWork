package HomeWork5.ui.commands;

import HomeWork5.ui.Console;

public class AddHuman extends Command
{
    public AddHuman(Console console) 
    {
        super(console);
    }

    @Override
    public String description() 
    {
        return "Добавление человека в семью. ";
    }
    
    @Override
    public void execute() 
    {
        getConsole().addHumanNew();
    }
}
