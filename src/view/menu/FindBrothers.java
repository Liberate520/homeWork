package view.menu;

import view.Console;

public class FindBrothers implements Command{
    public Console console;
    public String name;

    public FindBrothers(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Найти братьев";
    }

    @Override
    public void execute() {
        console.findBrothers();
    }
}
