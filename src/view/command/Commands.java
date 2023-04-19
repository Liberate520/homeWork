package view.command;

import java.util.LinkedHashMap;
import view.ConsoleUI;

public abstract class Commands {
    private ConsoleUI console;
    private String name;
    private String help;

    public Commands(ConsoleUI console) {
        this.console = console;
    }

    public String getCommandName() {
        return this.name;
    }

    public void setCommandName(String name) {
        this.name = name;
    }

    public String getCommandHelp() {
        return this.help;
    }

    public void setCommandHelp(String help) {
        this.help = help;
    }

    public ConsoleUI getConsole() {
        return this.console;
    }

    public abstract void execute(LinkedHashMap<String, String> map);

}
