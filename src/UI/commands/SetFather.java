package UI.commands;

import UI.Console;

public class SetFather extends Command{
    public SetFather(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Установить отца.";
    }

    @Override
    public void execute() {
        getConsole().setFather();
    }
}
