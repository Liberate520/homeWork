package ui.commands.commandsSecondaryMenu;

import ui.Console;
import ui.commands.Option;

public class ShowMother extends Option{
    public ShowMother(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Показать информацию о матери.";
    }

    @Override
    public void execute() {
        getConsole().showMother();
    }
}