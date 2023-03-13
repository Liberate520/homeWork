package View.Commands;

import View.Console;

public class SortByAge extends Command {

    public SortByAge(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировка по возрасту";
    }

    @Override
    public void execute() {
        getConsole().sortByAge();
    }
    
}
