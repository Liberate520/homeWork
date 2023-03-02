package ui.commands.commandsStartMenu;

import ui.Console;
import ui.commands.Option;

public class Exit extends Option{
    public Exit(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Выйти.";
    }

    @Override
    public void execute() {
        getConsole().endWork();
    }
    
}
