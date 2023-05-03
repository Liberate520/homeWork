package ui.commands.mainMenu;

import ui.ViewMainMenu;
import ui.commands.Command;

public class AddFamilyTree implements Command {
    private ViewMainMenu viewMainMenu;

    public AddFamilyTree(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
    }
    @Override
    public String getDescription() {
        return "Создать новое семейное дерево.";
    }

    @Override
    public void execute() {
        viewMainMenu.addFamilyTree();
    }
}
