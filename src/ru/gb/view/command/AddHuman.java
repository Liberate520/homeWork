package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().addHuman();
    }
}
