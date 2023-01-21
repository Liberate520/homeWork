package commands;

import ui.Console;

public class GetCalendar implements Commands {

    Console console;

    public GetCalendar(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {

        console.getPresenter().printCalendaryEntry(console.getCalendar());
    }

    @Override
    public String description() {
        return "показать весь календарь";
    }
}
