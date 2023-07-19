package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddPartner extends Command {

    public AddPartner(ConsoleUI consoleUI) {
        super(consoleUI, "добавить партнера");
    }

    @Override
    public void execute() {
        consoleUI.addPartner();
    }
}