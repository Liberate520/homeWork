package ui;

import ui.commands.workMenu.*;

import java.util.ArrayList;

public class WorkMenu extends Menu{
    private ViewWorkMenu viewWorkMenu;

    public WorkMenu(ViewWorkMenu viewWorkMenu){
        this.viewWorkMenu = viewWorkMenu;
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(viewWorkMenu));
        commandList.add(new PrintTree(viewWorkMenu));
        commandList.add(new FindHuman(viewWorkMenu));
        commandList.add(new FindHumanById(viewWorkMenu));
        commandList.add(new BackToMainMenu(viewWorkMenu));
    }
}
