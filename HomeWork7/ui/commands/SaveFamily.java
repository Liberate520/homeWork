package homeWork.HomeWork7.ui.commands;

import homeWork.HomeWork7.ui.Console;

public class SaveFamily extends Command
{
    public SaveFamily(Console console) 
    {
        super(console);
    }

    @Override
    public String description() 
    {
        return "Сохранить семью. ";
    }

    @Override
    public void execute() 
    {
        getConsole().saveFamily();      
    }
    
}