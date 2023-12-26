package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super("Finish interaction", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
