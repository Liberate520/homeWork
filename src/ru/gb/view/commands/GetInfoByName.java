package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class GetInfoByName extends Command{
    public GetInfoByName(ConsoleUI consoleUI) {
        super(consoleUI, "Получить инфо о человеке по имени");
    }

    @Override
    public void execute() {
        getConsole().getInfoByName();
    }
}
