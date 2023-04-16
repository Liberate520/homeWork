package view.commands;

import view.Console;

public class SortDate extends Command {
    public SortDate(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        getConsole().sortDate();
    }
}
