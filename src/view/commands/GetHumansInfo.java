package view.commands;

import view.ConsoleUI;

public class GetHumansInfo extends Command{
    public GetHumansInfo(ConsoleUI consoleUI) {


        super(consoleUI);
        description = "Получить дерево";
    }

    @Override
    public void execute() {
        consoleUI.getHumanListInfo();
    }
}
