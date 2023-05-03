package ui.commands.mainMenu;

import ui.ViewMainMenu;
import ui.commands.Command;

public class Finish implements Command {
    private ViewMainMenu viewMainMenu;

    public  Finish(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
    }

    @Override
    public String getDescription() {
        return "Завершить работу.";
    }

    @Override
    public void execute() {
        viewMainMenu.finish();
    }
}
