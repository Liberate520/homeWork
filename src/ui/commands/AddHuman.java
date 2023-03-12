package ui.commands;

import ui.Console;

public class AddHuman extends Command {
    
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить нового человека";
    }

    @Override
    public void execute() {
        getConsole().addHuman();
        System.out.println("Добавили человека");
    }
}
