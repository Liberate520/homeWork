package view.command;

import view.ConsoleUI;

public class AddFirstParent extends Command {

    public AddFirstParent(ConsoleUI console) {
        super(console);
        description = "Добавить первого родителя";
    }

    public void execute(){
        console.addChild();
    }
}
