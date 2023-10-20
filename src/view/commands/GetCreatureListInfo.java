package view.commands;

import view.ConsoleUI;

public class GetCreatureListInfo extends Command{

    public GetCreatureListInfo(ConsoleUI consoleUI) {
        super("Получить список", consoleUI);
    }

    public void execute(){
        getConsoleUI().getCreatureList();
    }
}
