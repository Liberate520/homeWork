package ui.commands.workMenu;

import ui.ViewWorkMenu;
import ui.commands.Command;

public class BackToMainMenu implements Command {
    private ViewWorkMenu viewWorkMenu;

    public BackToMainMenu(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
    }

    @Override
    public String getDescription() {
        return "Вернуться в главное меню";
    }

    @Override
    public void execute() {
        viewWorkMenu.finish();
    }
}
