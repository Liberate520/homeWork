package view.menu;

import view.Console;

public class AddHuman implements Command{
    public Console console;

    public AddHuman(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить человека в дерево";
    }

    @Override
    public void execute() {
        console.addHuman();
    }
}
