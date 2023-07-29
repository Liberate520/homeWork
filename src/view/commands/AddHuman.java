package view.commands;

import view.Console;

public class AddHuman extends Command {

    public AddHuman(Console console) {
        super(console);
        description = "Добавить нового человека в дерево";

    }

    public void execute() {
        console.addHuman();
    }

}
