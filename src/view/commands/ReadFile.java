package view.commands;


import view.Console;

public class ReadFile extends Command{

public ReadFile(Console console) {
        super(console);
        description = "Прочитать из файла";

    }

    @Override
    public void execute() {
        console.readFile();
    }

    

}
