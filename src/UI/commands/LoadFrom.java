package UI.commands;

import UI.Console;

public class LoadFrom extends Command{
    public LoadFrom(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Загрузить из файла.";
    }

    @Override
    public void execute() {
        getConsole().loadFrom();
    }
}
