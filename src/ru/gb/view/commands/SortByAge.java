package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Отсортировать по возрасту");
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
}
