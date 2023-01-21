package commands;

import ui.Console;

public class AddRecord implements Commands {

    Console console;

    public AddRecord(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().addRecord();
    }

    @Override
    public String description() {
        return "добавить запись";
    }
}
