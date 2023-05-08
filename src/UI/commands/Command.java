package UI.commands;

import java.io.IOException;

public interface Command {
    String description();
    void run() throws IOException;

}
