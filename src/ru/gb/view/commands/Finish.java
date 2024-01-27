package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Завершить работу");
    }

    @Override
    public void execute() {
        getConsole().finish();
    }
}
