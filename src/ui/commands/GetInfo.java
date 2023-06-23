package ui.commands;

import ui.Console;

public class GetInfo extends Command {

    public GetInfo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Получить список родственников";
    }

    @Override
    public void execute() {
        getConsole().getInfo();
    }
}
