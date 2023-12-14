package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class FindChildren extends Command {


    public FindChildren(ConsoleUi consoleUi) {
        super("Найти ребенка. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().findChildren();

    }
}
