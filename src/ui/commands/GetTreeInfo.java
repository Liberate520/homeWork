package ui.commands;

import ui.Console;


public class GetTreeInfo extends Command {
    public GetTreeInfo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Output all members of the genus.";
    }

    @Override
    public void execute() {
        getConsole().getTreeInfo();
    }
}
