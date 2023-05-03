package ui.commands.workMenu;

import ui.ViewWorkMenu;
import ui.commands.Command;

public class AddHuman implements Command {
    private ViewWorkMenu viewWorkMenu;

    public AddHuman(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
    }

    @Override
    public String getDescription() {
        return "Добавить человека в дерево";
    }

    @Override
    public void execute() {
        viewWorkMenu.addHuman();

    }
}
