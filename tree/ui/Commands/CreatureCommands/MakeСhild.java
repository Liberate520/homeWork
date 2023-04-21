package ui.Commands.CreatureCommands;

import ui.Console;
import ui.Commands.Command;

public class MakeСhild extends Command {

    public MakeСhild(Console console) {
        super(console);
        description = "Сделать персонажа ребенком";
    }

    @Override
    public void execute() {
        console.makeChild();
    }

}
