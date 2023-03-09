package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class SortTree extends Option{
    public SortTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Отсортировать дерево.";
    }

    @Override
    public void execute() {
        getConsole().sortTree();
    }
}
