package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public abstract class Command implements MCommand{
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI(){
        return consoleUI;
    }
    public String getDescription() {
        return description;
    }

}
