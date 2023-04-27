package view.commands;

import view.Console;

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
