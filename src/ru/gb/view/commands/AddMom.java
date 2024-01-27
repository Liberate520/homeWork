package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class AddMom extends Command {
    public AddMom(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить маму к члену древа");
    }

    @Override
    public void execute() {
        getConsole().addMom();
    }
}
