package view.commands;

import view.ConsoleUI;

public class GetHumanTreeInfo extends Command {
    public GetHumanTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список семейного дерева";
    }

    public void execute(){
        consoleUI.getFamalyTreeListInfo();
    }
}