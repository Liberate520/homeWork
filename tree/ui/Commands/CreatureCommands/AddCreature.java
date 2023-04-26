package ui.Commands.CreatureCommands;

import ui.Console;
import ui.Commands.Command;

public class AddCreature extends Command {

    public AddCreature(Console console) {
        super(console);
        description = "Создать нового персонажа";
    }

    @Override
    public void execute() {
        console.addCreature();
    }

}
