package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class Finish extends Command {
    public Finish(Console console) {
        super("Finish the job", console);
    }

    public void execute() {
        getConsole().finish();
    }
}
