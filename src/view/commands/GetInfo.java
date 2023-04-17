package view.commands;

import view.Console;

public class GetInfo extends Command {
    public GetInfo(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Информация: ";
    }

    @Override
    public void execute() {
        getConsole().getTreeInfo();
    }
}
