package view.commands;

import view.ConsoleUI;

public class GetAllHuman extends Commands {
    public GetAllHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей";
    }

    public void execute(){
        consoleUI.getAllHuman();
    }
}
