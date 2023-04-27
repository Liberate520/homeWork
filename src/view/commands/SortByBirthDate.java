package view.commands;

import view.Console;

public class SortByBirthDate extends Command {

    public SortByBirthDate(Console console) {
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
