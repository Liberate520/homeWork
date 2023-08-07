package view.commands;

import java.io.IOException;

public interface ICommand {
    String getDescription();
    void execute() throws IOException;
}
