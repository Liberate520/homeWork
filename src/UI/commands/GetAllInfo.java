package UI.commands;

import UI.Console;

public class GetAllInfo implements Command {
    private Console console;

    public GetAllInfo(Console console) {
        this.console = console;
    }

    @Override
    public String description() {
        return "Получить всю информацию о людях в дереве";
    }

    @Override
    public void run() {
        console.getAllInfo();
    }
}
