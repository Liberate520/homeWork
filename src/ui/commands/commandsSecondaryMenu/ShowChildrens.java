package ui.commands.commandsSecondaryMenu;

import ui.Console;
import ui.commands.Option;

public class ShowChildrens extends Option{
    public ShowChildrens(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Показать информацию о детях.";
    }

    @Override
    public void execute() {
        getConsole().showChildrens();
    }
}