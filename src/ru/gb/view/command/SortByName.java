package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super("Сортировка по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().SortByName();
    }
}
