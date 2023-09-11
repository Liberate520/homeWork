package view.commands;

import view.ConsoleUI;

public class GetInfo extends Command {

    public GetInfo(ConsoleUI consoleUI) {
        super("Get Info", consoleUI);

    }

    @Override
    public void execute() {
        super.getConsoleUI().getInfo();
    }
}
