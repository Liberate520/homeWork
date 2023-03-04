package src.ui.commands;

import java.io.IOException;

public interface Options {
    String description();
    void execute() throws IOException;
}
