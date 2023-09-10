package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Command{
    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Show item list", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().getHumanListInfo();
    }
}