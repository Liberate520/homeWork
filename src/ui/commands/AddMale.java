package ui.commands;

import human.Gender;
import ui.Console;

public class AddMale implements CommandGender{
    private Console console;

    public AddMale(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Male";
    }

    @Override
    public Gender execute() {
        return console.setMale();
    }
}
