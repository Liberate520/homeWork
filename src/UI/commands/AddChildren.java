package UI.commands;

import UI.Console;

public class AddChildren extends Command {
    public AddChildren(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Добавить потомка.";
    }

    @Override
    public void execute() {
        getConsole().addChildren();
    }
}
