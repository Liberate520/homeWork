package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

public class SetConnection extends Command{
    public SetConnection(ConsoleUI consoleUI) {
        super("Установка связи между людьми", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setConnection();
    }
}
