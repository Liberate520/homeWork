package ui.commands;

import ui.Console;

public class AddPerson extends Command
{
    public AddPerson(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Добавить персону";
    }

    @Override
    public void execute()
    {
        getConsole().consoleAddPerson();
    }
}
