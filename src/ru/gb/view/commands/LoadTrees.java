package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

import java.io.IOException;

public class LoadTrees extends Command {
    public LoadTrees(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить все сохраненные деревья");
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsole().loadTrees();
    }
}
