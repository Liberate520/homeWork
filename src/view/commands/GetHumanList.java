package view.commands;

import view.ConsoleUI;

public class GetHumanList {
    private ConsoleUI console;

    public GetHumanList(ConsoleUI console) {
        this.console = console;
    }

    public String getDescription(){
        return "Получить список людей";
    }

    public void execute(){
        console.getHumanList();
    }
}
