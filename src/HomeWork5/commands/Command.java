package HomeWork5.commands;

import HomeWork5.ui.Console;
import HomeWork5.ui.commands.Option;

public abstract class Command implements Option 
{
    private Console console;

    public Command(Console console) 
    {
        this.console = console;
    }

    public Console getConsole() 
    {
        return console;
    }
}
