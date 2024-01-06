package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class AddDad extends Command {
    public AddDad(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить папу к члену древа");
    }

    @Override
    public void execute() {
        getConsole().addDad();
    }
}
