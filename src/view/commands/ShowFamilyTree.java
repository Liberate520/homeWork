package view.commands;

import view.Console;

public class ShowFamilyTree extends Command {
    public ShowFamilyTree(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Вывести список объектов";
    }
    @Override
    public void execute() { getConsole().showList();
    }

}