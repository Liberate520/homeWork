package view.commands;

import view.ConsoleUI;

public class GetPersonInfo extends Command{
    public GetPersonInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать родственные связи человека по id";
    }

    public void execute(){
        consoleUI.getPersonInfo();
    }
}
