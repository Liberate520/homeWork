package view.commands;

import view.Console;

public class ShowTree extends Command{

    public ShowTree(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Показать всех людей дерева";
    }

    @Override
    public void execute() {
        getConsole().showTree();
    }
}
