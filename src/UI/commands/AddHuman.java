package UI.commands;

import UI.Console;

public class AddHuman implements Command {
    private Console console;

    public AddHuman(Console console) {
        this.console = console;
    }

    @Override
    public String description() {
        return "Добавить человека в дерево";
    }

    @Override
    public void run() {
        console.addHuman();
    }
}
