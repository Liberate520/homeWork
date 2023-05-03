package ui.commands;

import human.Gender;

public interface CommandGender {
    String getDescription();
    Gender execute();
}
