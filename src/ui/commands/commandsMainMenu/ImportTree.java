package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class ImportTree extends Option{
    public ImportTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Импортировать дерево в другой формат.";
    }

    @Override
    public void execute() {
        getConsole().importTree();
    }
}
