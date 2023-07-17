package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class WriteFile extends Command{
    public WriteFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Чтение сохраненного файла";
    }
    @Override
    public void execute() {

    }
}
