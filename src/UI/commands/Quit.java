package src.UI.commands;

import src.UI.Console;

public class Quit extends Command {


    public Quit(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Quit the program";
    }

    @Override
    public void execute() {
        System.out.println("Quit, files are closed");
    }
}
