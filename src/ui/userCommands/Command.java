package ui.userCommands;
import ui.ConsoleUI;

public abstract class Command {
    String description;
    private final ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }
    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract boolean execute();
}
