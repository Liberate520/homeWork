package View.Commands;

import View.Console;

public class SortByName extends Command {

    public SortByName(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сортировка по алфавиту";
    }

    @Override
    public void execute() {
        getConsole().SortByName();  
    }
    
}
