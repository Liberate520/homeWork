package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI console) {
        super(console);
        description = "Добавить человека в семейное древо";
    }
    public void execute(){
        console.addHuman();
    }

}
