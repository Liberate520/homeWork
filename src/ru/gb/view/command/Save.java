package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

import java.io.IOException;

public class Save extends Command{
    public Save(ConsoleUI consoleUI) {
        super("Сохранить в файл", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().save();
    }
}
