package view.commands;

import view.Console;

public class DataOutput extends Command {
    public DataOutput(Console console) {
        super(console);
    }
    @Override
    public String getDescription() {
        return "Обновить базу данных ";
    }
    @Override
    public void execute() {
        getConsole().dataSave();
    }
}
