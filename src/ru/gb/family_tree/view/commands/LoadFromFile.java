package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

import java.io.IOException;

public class LoadFromFile extends Command{
    public LoadFromFile(ConsoleView consoleView) {
        super(consoleView,"десериализация проекта");
    }

    @Override
    public void execute() {
        consoleView.loadFromFile();
    }
}
