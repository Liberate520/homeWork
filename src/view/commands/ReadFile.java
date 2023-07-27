package view.commands;

import java.io.Serializable;

import view.Console;

public class ReadFile extends Command{

public ReadFile(Console console) {
        super(console);
        description = "Прочитать из файла";

    }

    @Override
    public void execute() {
        Serializable dataForPrint = console.readFile();
        System.out.println("Прочитанные данные:\n" + dataForPrint);
    }

    

}
