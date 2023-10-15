package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class GetFamilyInfo extends Command{
    public GetFamilyInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Full family tree";
    }

    public void execute() {
        consoleUI.getFamilyInfo();
    }

}
