package HWGT.ui.commands;

import HWGT.ui.Console;

//команда находящаяся в списке команд на нулевой позиции - пользователю недоступна, обрабатывается при любых ошибках ввода, когда токен пункта меню возвращает 0.
public class ErrorInput extends Command{
    public ErrorInput(Console console){super(console);}

    @Override
    public String description(){return "неверный ввод";}

    @Override
    public void execute(){getConsole().errorInput();}
}
