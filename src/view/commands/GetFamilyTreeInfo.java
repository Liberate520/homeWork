package view.commands;

import view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "See family tree.";
    }

    public void execute(){
        consoleUI.getFamilyTreeInfo();
    }
}
