package ui.commands.components;

import ui.Console;
import ui.commands.Command;

public class Load extends Command {

    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Download list";
    }

    @Override
    public void execute() {
        getConsole().load();
    }
    
}
