package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;
import ru.gb.family_tree.view.commands.Command;

public class AddHuman extends Command {

    public AddHuman(ConsoleView consoleView) {
        super(consoleView, "добавить новый объект");
    }
    @Override
    public void execute() {
        consoleView.addHuman();
    }
}
