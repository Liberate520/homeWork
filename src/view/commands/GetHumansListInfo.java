package view.commands;

import view.ConsoleUI;

public class GetHumansListInfo extends Command {
    public GetHumansListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список членов семьи";
    }

    public void execute(){
        consoleUI.getHumansListInfo();
    }
}
