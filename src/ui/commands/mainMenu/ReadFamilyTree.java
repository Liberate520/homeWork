package ui.commands.mainMenu;

import ui.ViewMainMenu;
import ui.commands.Command;

public class ReadFamilyTree implements Command {
    private ViewMainMenu viewMainMenu;

    public  ReadFamilyTree(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
    }

    @Override
    public String getDescription() {
        return "Загрузить семейное дерево.";
    }

    @Override
    public void execute() {
        viewMainMenu.readFamilyTree();
    }
}
