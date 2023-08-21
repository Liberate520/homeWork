package view.commands;

import view.ConsoleUI;

public class GetFamilysInfo extends Command {
    public GetFamilysInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список семьи";
    }

    public void execute(){
        consoleUI.getFamilysListInfo();
    }
}
