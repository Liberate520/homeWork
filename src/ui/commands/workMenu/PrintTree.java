package ui.commands.workMenu;

import ui.ViewWorkMenu;
import ui.commands.Command;

public class PrintTree implements Command {
    private ViewWorkMenu viewWorkMenu;
    public PrintTree(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
    }
    @Override
    public String getDescription() {
        return "Вывести дерево";
    }
    @Override
    public void execute() {
        viewWorkMenu.printTree();
    }
}
