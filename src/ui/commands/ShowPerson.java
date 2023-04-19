package ui.commands;

import ui.Console;

public class ShowPerson extends Command{
    public ShowPerson(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать весь список.";
    }

    @Override
    public void execute() {
        getConsole().showPerson();
    }
}
