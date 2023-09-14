package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI console) {
        super(console);
        description = "Добавить человека";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}
