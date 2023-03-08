package commands;

import UI.Console;

public class ShowEntry extends Command {
    public ShowEntry(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать информацию о человеке";
    }

    @Override
    public void execute() {
        super.getConsole().showEntry();
    }
}