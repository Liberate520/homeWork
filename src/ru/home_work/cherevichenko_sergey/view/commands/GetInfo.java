package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public class GetInfo extends Command {
    public GetInfo(ConsoleUi consoleUi) {
        super("Вывести всю информацию о древе. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getInfo();

    }
}
