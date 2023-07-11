package org.genealogy.view.commands;

import org.genealogy.view.ConsoleUI;

public class GetHumanInfo extends Command{
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список людей";
    }

    public void execute(){
        consoleUI.getHumanListInfo();
    }
}
