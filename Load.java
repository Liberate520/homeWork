package commands;

import UI.Console;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать дерево";
    }

    @Override
    public void execute() {
        super.getConsole().load();
    }
}