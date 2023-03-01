package HW01.ui.commands;

import HW01.ui.Console;

public class SortByBitrhDate extends Command {

    public SortByBitrhDate(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Сортировать записи по году рождения";
    }

    @Override
    public void execute() {
        getConsole().sortByBirthDate();
    }

}
