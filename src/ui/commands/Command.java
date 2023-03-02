package ui.commands;

import java.io.IOException;

public interface Command {
    String descriprion(); // для чего эта команда
    void execute() throws ClassNotFoundException, IOException; // что выполняет
}
