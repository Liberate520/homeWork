package ui.commands;

import ui.Console;

public class AddChild extends Command{
    public AddChild (Console console) {
        super(console);
        description = "Добавить ребенка";
    }

    @Override
    public void execute() {
        console.addChild();
    }
}