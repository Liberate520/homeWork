package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class GetFamilyInfo extends Command{
    public GetFamilyInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get full family tree list";
    }

    public void execute() {
        consoleUI.getFamilyInfo();
    }

}
