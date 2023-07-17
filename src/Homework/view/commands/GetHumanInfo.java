package Homework.view.commands;

import Homework.view.ConsoleUI;

public class GetHumanInfo extends Command{
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список членов семьи";
    }

    public void execute(){
        consoleUI.getHumanInfo();
    }
}
