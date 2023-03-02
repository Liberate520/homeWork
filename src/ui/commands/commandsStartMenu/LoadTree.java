package ui.commands.commandsStartMenu;

import java.io.IOException;

import ui.Console;
import ui.commands.Option;

public class LoadTree extends Option{
    public LoadTree(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Загрузить дерево.";
    }

    @Override
    public void execute() throws ClassNotFoundException, IOException {
        getConsole().loadTree();
    }
}
