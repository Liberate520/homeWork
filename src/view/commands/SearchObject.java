package view.commands;

import view.Console;

public class SearchObject extends Command{

    public SearchObject(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Найти объект";
    }

    @Override
    public void execute() {
        System.out.println("Нахожу...");
        getConsole().Search();
    }
}
