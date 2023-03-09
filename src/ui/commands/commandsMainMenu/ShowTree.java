package ui.commands.commandsMainMenu;

import ui.Console;
import ui.commands.Option;

public class ShowTree extends Option{
    public ShowTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Показать дерево.";
    }

    @Override
    public void execute() {
        getConsole().showTree();
    }
    
}
