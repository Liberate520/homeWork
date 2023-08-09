package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

import java.io.IOException;

public class Load extends Command{
    public Load(ConsoleUI consoleUI) {
        super("Загрузить из файла", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        super.getConsoleUI().load();
    }
}

