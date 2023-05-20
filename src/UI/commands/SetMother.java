package UI.commands;

import UI.Console;

public class SetMother extends Command{
    public SetMother(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Установить мать.";
    }

    @Override
    public void execute() {
        getConsole().setMother();
    }
}
