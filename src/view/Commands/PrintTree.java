package View.Commands;

import View.Console;

public class PrintTree extends Command{

    public PrintTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать все дерево";
    }

    @Override
    public void execute() {
        getConsole().printTree();
    }
    
}
