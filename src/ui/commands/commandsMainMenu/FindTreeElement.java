package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class FindTreeElement extends Option{
    public FindTreeElement(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Поиск по имени.";
    }

    @Override
    public void execute() {
        getConsole().findTreeElement();
    }
}
