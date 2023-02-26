package HW01.ui.commands;

import java.io.IOException;

public interface Option {
    String description();
    void execute() throws IOException, ClassNotFoundException;
}