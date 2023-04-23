package View.Comands;

import View.Console;

public class SortByBirthday extends Command{
    public SortByBirthday(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        getConsole().sortByBirthday();
    }
}
