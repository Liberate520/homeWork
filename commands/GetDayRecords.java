package commands;

import ui.Console;

public class GetDayRecords implements Commands {

    Console console;

    public GetDayRecords(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().getDayRecords();
    }

    @Override
    public String description() {
        return "показать записи на определённый день";
    }
}
