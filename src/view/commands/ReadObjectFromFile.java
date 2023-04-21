package view.commands;

import view.Console;

public class ReadObjectFromFile extends Command {


    public ReadObjectFromFile(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Считать объекты из файла";
    }

    @Override
    public void execute() {
        System.out.println("Считываю файл...");
        getConsole().readFile();
    }
}
