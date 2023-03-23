package ui.commands;

import ui.Console;

public class PrintTree extends Command {
    public PrintTree(Console console){
        super(console);
    }

    @Override
    public String description() {
        return "Вывести дерево целиком";
    }

    @Override
    public void execute() {
        getConsole().printTree();
    }
}