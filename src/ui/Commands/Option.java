package ui.Commands;

import java.io.IOException;

public interface Option {
    String description();

    void execute() throws ClassNotFoundException, IOException;
}
