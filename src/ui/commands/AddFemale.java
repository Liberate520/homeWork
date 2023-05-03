package ui.commands;

import human.Gender;
import ui.Console;

public class  AddFemale implements CommandGender{
    private Console console;

    public AddFemale(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Female";
    }

    @Override
    public Gender execute() {
        return console.setFemale();

    }
}
