package ui;

public abstract interface Command {
    String getDescription();
    void execute();
}
