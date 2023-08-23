package FT_Project.view.Actions;

import FT_Project.view.Console;

public class AddHuman extends Action{

    public AddHuman(Console console) {
        super(console);
        description = "Добавить новую запись";
    }

    public void execute(){
        console.addHuman();
    }
}
