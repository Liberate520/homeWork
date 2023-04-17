package ui.commands;

import ui.Console;

public class SaveList extends Command{
    public SaveList(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Сохранить список людей";
    }
    @Override
    public void execute() {
        getConsole().addHuman();
    }
}
