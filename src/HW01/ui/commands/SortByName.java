package HW01.ui.commands;

import HW01.ui.Console;

public class SortByName extends Command {

    public SortByName(Console console) {
        super(console);
    }

    @Override
        public String description() {
            return "Сортировать записи по имени";
    }

    @Override
    public void execute() {
        getConsole().sortByName();
    }

}
