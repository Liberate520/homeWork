package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public class AddParentAndChildren extends Command{

    public AddParentAndChildren( ConsoleUi consoleUi) {
        super("Добавить родителя с ребенком.", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().addParentAndChildren();

    }
}
