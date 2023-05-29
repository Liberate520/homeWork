package ui.commands;

import ui.Console;

import java.io.IOException;

public class SaveFile implements Command{
    private Console console;

    public SaveFile(Console console){
        this.console = console;
    }
    @Override
    public String getDescription() {
        return "Сохранить в файл";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        console.save();
        System.out.println("Записано в файл успешно");
    }
}
