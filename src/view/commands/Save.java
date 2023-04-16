package view.commands;

import view.Console;
public class Save extends Command {
    public Save(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Сохранить дерево в файл";
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}
