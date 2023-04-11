package view.commands;

import view.Console;

public class AddObject extends Command {

    public AddObject(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новый объект в дерево";
    }

    @Override
    public void execute() {
        System.out.println("Добавляю...");
        getConsole().addObject();
    }
}
