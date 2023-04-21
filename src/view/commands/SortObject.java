package view.commands;

import view.Console;

public class SortObject extends  Command{
    public SortObject(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировать список";
    }

    @Override
    public void execute() {
        System.out.println("Сортирую...");
        getConsole().sortObg();
    }
}
