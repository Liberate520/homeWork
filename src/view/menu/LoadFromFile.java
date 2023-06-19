package view.menu;

import view.Console;

import java.io.IOException;

public class LoadFromFile implements Command{
    public Console console;

    public LoadFromFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Загрузить дерево из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        console.loadFromFile();
    }
}
