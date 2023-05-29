package ui.commands;

import ui.Console;

public class GetInfo implements Command{
    private Console console;

    public GetInfo(Console console){
        this.console = console;
    }
    @Override
    public String getDescription() {
        return "Вывести список";
    }

    @Override
    public void execute() {
        console.getInfo();
    }
}
