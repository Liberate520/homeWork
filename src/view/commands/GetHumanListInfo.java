package view.commands;

import view.ConsoleUI;

public class GetHumanListInfo extends Command{
    public GetHumanListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Список всех людей в древе.";
    }

    @Override
    public void execute() {
        consoleUI.getHumanListInfo();
    }
}
