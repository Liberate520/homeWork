package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class SortByAge extends Command {
    public SortByAge( ConsoleUi consoleUi) {
        super("Отсортировать древо по возрасту. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByAge();

    }
}
