package view.comands;

import view.Console;

public class AddHuman extends Command {

    public AddHuman(Console console) {
        super(console);

    }

    public String getDescription(){
        return "Добавить людей";
    }

    public void execute(){
        console.AddHuman();
    }
}

