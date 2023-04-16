package view.commands;

import view.Console;

public class SortName extends Command{
    public SortName(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Отсортировать по имени";
    }

    @Override
    public void execute() {
        getConsole().sortName();
    }
}
