package view.commands;

import view.Console;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Загрузить дерево из файла";
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
