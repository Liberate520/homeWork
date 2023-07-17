package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

public class Finish extends Command {
    public Finish(ConsoleView consoleView) {
        super(consoleView, "выйти из программы");
    }

    @Override
    public void execute() {
        consoleView.finish();
    }
}
