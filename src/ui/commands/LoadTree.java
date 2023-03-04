package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class LoadTree extends Command {
    public LoadTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Загрузить файл";
    }

    @Override
    public void execute(){
        getConsole().loadTree();
    }
}
