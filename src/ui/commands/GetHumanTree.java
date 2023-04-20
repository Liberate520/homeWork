package ui.commands;

import ui.Console;

public class GetHumanTree extends Command{
    public GetHumanTree(Console console) {
        super(console);
        description = "Вывести дерево";
    }

    @Override
    public void execute() {
        console.getHumanTree();
    }
}
