package ui.commands.commandsSecondaryMenu;

import ui.Console;
import ui.commands.Option;

public class ReturnMainMenu extends Option{
    public ReturnMainMenu(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Вернуться в основное меню.";
    }

    @Override
    public void execute() {
        getConsole().returnMainMenu();
    }
}