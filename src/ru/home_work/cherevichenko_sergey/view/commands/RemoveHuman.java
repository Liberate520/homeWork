package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class RemoveHuman extends Command {
    public RemoveHuman( ConsoleUi consoleUi) {
        super("Удалить человека. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().removeHuman();

    }
}
