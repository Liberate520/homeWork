package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public class AddChildForFamily extends Command {
    public AddChildForFamily(ConsoleUi consoleUi) {
        super("Добавить ребенка семье. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addChildForFamily();

    }
}
