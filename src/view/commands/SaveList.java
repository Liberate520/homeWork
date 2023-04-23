package view.commands;

import view.Console;

public class SaveList extends Command{
    public SaveList(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Сохранить изменения в файл";
    }
    @Override
    public void execute() {
        getConsole().saveList();
    }
}