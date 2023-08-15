package family_tree.view.commands;

import family_tree.view.view.ConsoleUI;

public abstract class Command implements ICommand{
    private String commandDescription;
    private ConsoleUI console;

    public Command(String commandDescription, ConsoleUI console) {
        this.commandDescription = commandDescription;
        this.console = console;
    }

    public ConsoleUI getConsole() {
        return console;
    }

    public String getCommandDescription(){
        return commandDescription;
    }
}
