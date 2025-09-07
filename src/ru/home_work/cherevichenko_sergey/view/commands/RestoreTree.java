package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class RestoreTree extends Command {
    public RestoreTree(ConsoleUi consoleUi) {
        super("Восстановить последнею версию древа. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().restoreTree();

    }
}
