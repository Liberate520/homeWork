package src.ui.commands;

import src.ui.Console;

import java.io.IOException;

public class SaveTree extends Command{
    public SaveTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить генеалогическое древо в файл";
    }

    @Override
    public void execute() {
        getConsole().saveTree();
    }
}
