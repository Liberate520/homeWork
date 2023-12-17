package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class SortByName extends Command {
    public SortByName(ConsoleUi consoleUi) {
        super("Отсортировать древо по имени. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByName();

    }
}
