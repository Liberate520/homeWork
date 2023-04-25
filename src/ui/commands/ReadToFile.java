package ui.commands;

import ui.Console;

public class ReadToFile extends Command {
    public ReadToFile(Console console){
        super(console);
    }
    public String getDescription(){
        return "Открыть дерево из файла";
    }

    public void execute(){
        getConsole().readToFile();
    }
}
