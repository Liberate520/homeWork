package ui.commands;

import ui.Console;

import java.io.IOException;

public class ReadFile implements Command{
    private Console console;


    public ReadFile(Console console) {
        this.console = console;
    }
    @Override
    public String getDescription() {
        return "Открыть из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
    console.read();
    System.out.println("Данные прочитаны");
    }
}
