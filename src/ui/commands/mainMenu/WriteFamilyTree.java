package ui.commands.mainMenu;

import ui.ViewMainMenu;
import ui.commands.Command;

public class WriteFamilyTree implements Command {
    private ViewMainMenu viewMainMenu;

    public  WriteFamilyTree(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
    }

    @Override
    public String getDescription() {
        return "Сохранить семейное дерево.";
    }

    @Override
    public void execute() {
        viewMainMenu.writeFamilyTree();
    }
}