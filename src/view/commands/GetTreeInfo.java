package view.commands;

import view.Console;

public class GetTreeInfo extends Command {
    public GetTreeInfo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        getConsole().getTreeInfo();
    }
}
