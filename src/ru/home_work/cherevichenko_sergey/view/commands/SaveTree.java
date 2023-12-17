package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;
import ru.home_work.cherevichenko_sergey.view.commands.Command;

public class SaveTree extends Command {
    public SaveTree(ConsoleUi consoleUi) {
        super("Сохранить древо. ", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().saveTree();

    }
}
