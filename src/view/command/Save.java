package view.command;

import view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI console) {
        super(console);
        description = "Сохранить в файл";
    }

    public void execute(){
        console.save();
    }
}
