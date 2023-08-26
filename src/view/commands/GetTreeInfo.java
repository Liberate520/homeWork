package view.commands;

import view.ConsoleUI;

public class GetTreeInfo extends Command {
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Покажи генеологическое дерево";
    }

    public void execute(){
        consoleUI.getTreeInfo();
    }
}
