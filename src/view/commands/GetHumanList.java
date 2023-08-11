package view.commands;

import view.ConsoleUI;

public class GetHumanList extends Command {
    public GetHumanList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Покажи генеологическое дерево";
    }

    public void execute(){
        consoleUI.getHumanList();
    }
}
