package HWGT.ui.commands;

import HWGT.ui.Console;

public class UpdatePerson extends Command{
    public UpdatePerson(Console console){super(console);}

    @Override
    public String description(){return "Обновить информацию о человеке";}

    @Override
    public void execute(){getConsole().updatePerson();}
}
