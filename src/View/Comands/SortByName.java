package View.Comands;

import View.Console;

public class SortByName extends Command{

    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Отсортировать по имени";
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }
}
