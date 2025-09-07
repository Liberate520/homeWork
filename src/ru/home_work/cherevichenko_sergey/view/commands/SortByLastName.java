package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class SortByLastName extends Command {
    public SortByLastName(ConsoleUi consoleUi) {
        super("Отсортировать древо по фамилии.  ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByLastName();

    }
}
