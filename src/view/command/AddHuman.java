package view.command;

import view.ConsoleUI;
public class AddHuman extends Command {

    public AddHuman(ConsoleUI console) {
        super(console);
        description = "Добавить человека";
    }

    public void execute(){
        console.addHuman();
    }
}
