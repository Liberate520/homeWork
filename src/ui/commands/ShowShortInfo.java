package ui.commands;

import ui.Console;

public class ShowShortInfo implements Command {
    Console console;

    public ShowShortInfo(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.showShortInfo();
    }

    @Override
    public String getDescription() {
        return "Вывести краткую информацию по генеалогическому дереву";
    }
    
}


