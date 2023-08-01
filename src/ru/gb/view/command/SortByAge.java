package ru.gb.view.command;

import ru.gb.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировка по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().SortByAge();
    }
}
