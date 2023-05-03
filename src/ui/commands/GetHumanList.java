package ui.commands;

import human.Gender;
import ui.Console;

public class GetHumanList implements Command{
    private Console console;

    public GetHumanList(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Получить список людей";
    }

    @Override
    public void execute() {
        console.getHumanList();
    }
}
