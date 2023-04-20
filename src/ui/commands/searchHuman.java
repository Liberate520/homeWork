package ui.commands;

import ui.Console;
import ui.commands.Command;

public class searchHuman extends Command {
    public searchHuman(Console console) {
        super(console);
        description = "Найти человека";
    }
//    @Override
//    public void execute() {
//        console.searchHuman();
//    }
}
