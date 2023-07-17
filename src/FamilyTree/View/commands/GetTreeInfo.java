package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

public class GetTreeInfo extends Command {
    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести дерево";
    }

    public void execute(){
        consoleUI.getStudentsListInfo();
    }
}
