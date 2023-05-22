package ui;

import ui.commands.mainMenu.*;

import java.util.ArrayList;

public class MainMenu extends Menu{
    private ViewMainMenu viewMainMenu;

    public MainMenu(ViewMainMenu viewMainMenu){
        this.viewMainMenu = viewMainMenu;
        commandList = new ArrayList<>();
        commandList.add(new AddFamilyTree(viewMainMenu));
        commandList.add(new ReadFamilyTree(viewMainMenu));
        commandList.add(new WriteFamilyTree(viewMainMenu));
        commandList.add(new WorkWithTree(viewMainMenu));
        commandList.add(new Finish(viewMainMenu));
    }
}
