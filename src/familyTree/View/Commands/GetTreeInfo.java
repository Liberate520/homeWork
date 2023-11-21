package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Запросить список членов семьи";
    }

    @Override
    public void execute() {
        consoleUI.getTreeListInfo();
    }
}

