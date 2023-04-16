package ui.commands;

import ui.ConsoleUI;

public class RequestPrint extends Command{
    public RequestPrint(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести на экран информацию по всем существующим генеалогическим деревьям";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestPrint();
    }
}
