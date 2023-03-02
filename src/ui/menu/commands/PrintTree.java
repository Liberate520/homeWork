package ui.menu.commands;

import ui.ConsoleOne;

public class PrintTree extends Command{

    public PrintTree(ConsoleOne console) {
        super(console);
    }

    @Override
    public String description() {
        return "Show tree";
    }

    @Override
    public void execute() {
        getConsole().printTree();
    }

}
