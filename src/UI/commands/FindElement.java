package UI.commands;

import UI.Console;

public class FindElement extends Command {

    public FindElement(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Найти члена генеалогического древа";
    }

    @Override
    public void execute() {
        getConsole().findElement();
    }
}
