package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class AddPartner extends Command {

    public AddPartner(ConsoleView consoleView) {
        super(consoleView, "добавить партнера");
    }
    @Override
    public void execute() {
        consoleView.addPartner();
    }
}
