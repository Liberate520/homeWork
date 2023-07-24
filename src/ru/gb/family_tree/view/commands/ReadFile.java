package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class ReadFile extends Command{
    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Чтение сохраненного файла";
    }
    @Override
    public void execute() {consoleUI.readFile();}
}
