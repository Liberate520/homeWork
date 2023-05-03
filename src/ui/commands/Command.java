package ui.commands;

import human.Gender;

public interface Command {
    String getDescription();
    void execute();

}
