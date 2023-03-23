package ui.commands;

import ui.Console;

public class LoadData extends Command {
    public LoadData(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Загрузить данные";
    }

    @Override
    public void execute() throws Exception {
        getConsole().loadData();

    }
}
