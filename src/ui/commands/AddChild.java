package ui.commands;

import human.Gender;
import ui.Console;

public class AddChild implements Command{
    private Console console;

    public AddChild(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() {
        console.addChild();
    }
}
