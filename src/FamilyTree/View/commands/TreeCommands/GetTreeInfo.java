package FamilyTree.View.commands.TreeCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class GetTreeInfo extends Command {
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести дерево";
    }

    public void execute(){
        consoleUI.getTreeInfo();
    }
}
