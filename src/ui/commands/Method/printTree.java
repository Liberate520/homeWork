package ui.commands.Method;

import ui.ConsoleUI;
import ui.commands.Option;

public class printTree implements Option {
    private ConsoleUI consoleUI;

    public printTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String description() {
        return "print tree";
    }

    @Override
    public void execute() {
        consoleUI.printTree();
    }
    
}
