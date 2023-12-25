package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class AddHuman extends Command {
    public AddHuman(Console console) {
        super("Add a person", console);
    }

    public void execute() {
        getConsole().addHuman();
    }
}
