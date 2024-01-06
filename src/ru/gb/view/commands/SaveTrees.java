package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

import java.io.IOException;

public class SaveTrees extends Command {
    public SaveTrees(ConsoleUI consoleUI) {
        super(consoleUI, "Сохранить все деревья");
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole().saveTrees();
    }
}
