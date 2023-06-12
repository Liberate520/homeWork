package view.commands;

public interface Command {
    String getDescription();

    void execute();
}
