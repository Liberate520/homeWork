package ui.commands;

import ui.Console;

public class LoadList extends Command {
    public LoadList(Console console) {
        super(console);
    }
    @Override
    public String description() {
        return "Загрузка данных из файла";
    }
    @Override
    public void execute(){
        getConsole().loadFile();
    }

}