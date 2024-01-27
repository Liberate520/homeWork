package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class GetAllTreesInfo extends Command{
    public GetAllTreesInfo(ConsoleUI consoleUI) {
        super(consoleUI, "Получить инфо обо всех древах");
    }

    @Override
    public void execute() {
        getConsole().getAllTreesInfo();
    }
}
