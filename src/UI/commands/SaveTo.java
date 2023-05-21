package UI.commands;

import UI.Console;

public class SaveTo extends Command{

    public SaveTo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Запомнить в файл.";
    }

    @Override
    public void execute() {
        getConsole().saveTo();
    }
}
