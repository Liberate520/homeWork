package HWGT.ui.commands;

import HWGT.ui.Console;

public class ErrorInput extends Command{
    public ErrorInput(Console console){super(console);}

    @Override
    public String description(){return "неверный ввод";}

    @Override
    public void execute(){getConsole().errorInput();}
}
