package ui.commands.workMenu;

import ui.ViewWorkMenu;
import ui.commands.Command;

public class FindHumanById implements Command {
    private ViewWorkMenu viewWorkMenu;

    public FindHumanById(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
    }

    @Override
    public String getDescription() {
        return "Найти человека по ID";
    }

    @Override
    public void execute() {
        viewWorkMenu.findHumanById();
    }
}
