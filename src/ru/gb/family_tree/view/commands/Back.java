package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Back extends Command {

    public Back(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Назад";
    }

    @Override
    public void execute() { consoleUI.back(); }
}
