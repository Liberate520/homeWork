package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по имени");
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
