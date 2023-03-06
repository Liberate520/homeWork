package ui.commands;

import ui.Console;

public class FindPerson extends Command
{
    public FindPerson(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Найти персону";
    }

    @Override
    public void execute()
    {
        getConsole().consoleFindPerson();
    }
}
