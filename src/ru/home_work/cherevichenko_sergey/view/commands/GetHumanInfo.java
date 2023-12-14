package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUi consoleUi) {
        super("Вывести всю информацию о древе. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getHumanInfo();

    }
}
