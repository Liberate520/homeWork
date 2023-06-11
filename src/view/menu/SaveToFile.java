package view.menu;

import view.Console;

import java.io.IOException;

public class SaveToFile implements Command{
    public Console console;

    public SaveToFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сохранить дерево в файл";
    }

    @Override
    public void execute() throws IOException {
        console.saveToFile();
    }
}
