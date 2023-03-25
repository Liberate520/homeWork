package view.operations;

import view.ConsoleUI;

public class Exit extends ViewTasker {
    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Выйти из программы       ";
    }
    //         "Добавить новое занятие"
    @Override
    public void execute() {
        getConsole().end();
    }
}