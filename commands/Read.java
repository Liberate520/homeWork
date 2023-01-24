package commands;

import ui.Console;

public class Read implements Commands {

    Console console;

    public Read(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {

        console.getPresenter().readCalendar();

    }

    @Override
    public String description() {
        return "Открыть файл";
    }
}