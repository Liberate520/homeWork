package familytree.view.comands;

import familytree.view.Console;

public class AddHuman extends Comand {
    
    public AddHuman(Console console) {
        super(console);
        description = "Добавить нового человека";

    }

    public void execute() {
        console.addHuman();
    }

}