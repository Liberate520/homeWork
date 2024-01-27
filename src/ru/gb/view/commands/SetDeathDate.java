package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class SetDeathDate extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI, "Установить дату смерти");
    }

    @Override
    public void execute() {
        getConsole().setDeathDate();
    }
}
