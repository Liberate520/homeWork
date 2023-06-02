package ui.commands;

public abstract interface Command {
   
    String getDescription();

    void execute();
}
