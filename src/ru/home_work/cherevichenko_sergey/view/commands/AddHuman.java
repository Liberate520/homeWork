package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public class AddHuman extends Command {


    public AddHuman(ConsoleUi consoleUi) {
        super("Добавить человека. ", consoleUi);
    }


    @Override
    public void execute() {
        getConsoleUi().addHuman();
    }
}
