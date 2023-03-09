package ui.commands.commandsSecondaryMenu;

import ui.Console;
import ui.commands.Option;

public class ShowFather extends Option{
    public ShowFather(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Показать информацию об отце.";
    }

    @Override
    public void execute() {
        getConsole().showFather();
    }
}