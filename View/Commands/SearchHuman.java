package View.Commands;

import View.Console;

public class SearchHuman extends Command {

    public SearchHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Найти человека";
    }

    @Override
    public void execute() {
        getConsole().searchHuman();
    }
    
}
