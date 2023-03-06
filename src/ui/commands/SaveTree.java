package ui.commands;

import ui.Console;

import java.io.IOException;

public class SaveTree extends Command
{
    public SaveTree(Console console)
    {
        super(console);
    }
    @Override
    public String description()
    {
        return "Сохранить дерево";
    }

    @Override
    public void execute() throws IOException {
        getConsole().consoleSaveTree();
    }
}
