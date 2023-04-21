package ui.Commands.FamilyCommands;

import ui.Console;
import ui.Commands.Command;

public class ViewFamily extends Command {

    public ViewFamily(Console console) {
        super(console);
        description = "Просмотреть состав семьи";
    }

    @Override
    public void execute() {
        console.viewFamily();
    }

}
