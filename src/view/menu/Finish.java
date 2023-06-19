package view.menu;

import view.Console;

public class Finish implements Command{
    public Console console;

    public Finish(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute() {
        console.finish();
    }
}
