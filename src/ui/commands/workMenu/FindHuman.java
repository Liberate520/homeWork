package ui.commands.workMenu;

import ui.ViewWorkMenu;
import ui.commands.Command;

public class FindHuman implements Command {
    private ViewWorkMenu viewWorkMenu;

    public FindHuman(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
    }

    @Override
    public String getDescription() {
        return "Найти человека";
    }

    @Override
    public void execute() {
        viewWorkMenu.findHuman();
    }
}
