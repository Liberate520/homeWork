package ui.Commands.CreatureCommands;

import ui.Console;
import ui.Commands.Command;

public class ViewInfoByNames extends Command {

    public ViewInfoByNames(Console console) {
        super(console);
        description = "Просмотр родственных связей по человеку";
    }

    @Override
    public void execute() {
        console.viewInfoByNames();
    }

}
