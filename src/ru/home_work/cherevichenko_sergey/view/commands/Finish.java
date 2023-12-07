package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public class Finish extends Command{
    public Finish( ConsoleUi consoleUi) {
        super("Закончить работу.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();

    }
}
