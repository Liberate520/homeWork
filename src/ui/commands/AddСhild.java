package src.ui.commands;

import src.ui.Console;

public class AddСhild extends Command {


    public AddСhild(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() {
        getConsole().addChild();
    }
}
