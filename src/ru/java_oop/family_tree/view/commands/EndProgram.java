package ru.java_oop.family_tree.view.commands;

import ru.java_oop.family_tree.view.ConsoleUI;

public class EndProgram extends Command {

    public EndProgram(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Exit program";
    }

    @Override
    public void execute() {
        consoleUI.endProgram();
    }
}
