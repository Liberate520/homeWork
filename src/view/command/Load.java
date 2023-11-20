package view.command;

import view.ConsoleUI;

public class Load extends Command{
    public Load(ConsoleUI console) {
        super(console);
        description = "Загрузить из файла";
    }

    public void execute(){
        console.load();
    }
}
