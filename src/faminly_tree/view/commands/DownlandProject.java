package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class DownlandProject extends Command{

    public DownlandProject(ConsoleUI console) {
        super(console);
        description = "Открыть проект";
    }

    @Override
    public void execute() {
        console.downlandProject();
    }
}
