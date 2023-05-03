package ui.commands.mainMenu;

import ui.ViewMainMenu;
import ui.commands.Command;

public class WorkWithTree implements Command {
    private ViewMainMenu viewMainMenu;
    public WorkWithTree(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
    }
    @Override
    public String getDescription() {
        return "Работать с деревом";
    }

    @Override
    public void execute() {
        viewMainMenu.workWithTree();

    }
}
