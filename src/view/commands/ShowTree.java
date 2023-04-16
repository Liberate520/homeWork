package view.commands;

import view.Console;

public class ShowTree extends Command{

    public ShowTree(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Показать дерево";
    }

    @Override
    public void execute() {
        getConsole().showTree();
    }
}
