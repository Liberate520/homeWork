package ui.optionConsole;

import ui.Console;

public class GetTree extends Option {

    public GetTree(Console console) {
        super(console);
        setDescription("Вывести семейное дерево.");
    }

    @Override
    public void execute() {
        super.getConsole().getTree();
    }
}
