package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class LoadFromFile extends Command{
    public LoadFromFile(ConsoleUI consoleUI) {
        super(consoleUI,"десериализация проекта");
    }

    @Override
    public void execute() {
        consoleUI.loadFromFile();
    }
}