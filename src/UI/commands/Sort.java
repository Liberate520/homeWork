package UI.commands;

import UI.Console;

public class Sort extends Command{

    public Sort(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Сортировка.";
    }

    @Override
    public void execute() {
        getConsole().sort();
    }
}
