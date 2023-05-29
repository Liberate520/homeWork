package ui.commands;

import java.io.IOException;

public interface Command {
    String getDescription();
    void execute() throws IOException, ClassNotFoundException;
}
