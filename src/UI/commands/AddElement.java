package UI.commands;

import UI.Console;

public class AddElement extends Command {
    public AddElement(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Добавить нового члена генеалогического древа";
    }

    @Override
    public void execute() {
        getConsole().addElement();
    }
}
