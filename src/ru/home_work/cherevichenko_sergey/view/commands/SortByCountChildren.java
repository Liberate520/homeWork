package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class SortByCountChildren extends Command {
    public SortByCountChildren(ConsoleUi consoleUi) {
        super("Отсортировать древо по количеству детей. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByCountChildren();

    }
}
