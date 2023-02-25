package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class ShowTree extends Command  {
    public ShowTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать деверо";
    }

    @Override
    public void execute() throws IOException {
        getConsole().showTree();
    }
}
