package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public class NotFound extends Commands {
    private final String name = "notfound";
    private final String help = "";

    public NotFound(ConsoleUI console){
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole().print("Command not found!");
    }

}
