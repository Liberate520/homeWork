package ui.menu;

import ui.UI;
import ui.menu.command.Command;
import ui.menu.command.ExitMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Menu {
    private List<Command> commandList;
    private String menuHeader;
    private boolean active;
    public Menu(UI view, boolean addExitCMD, String menuHeader, Command ...commands) {
        active = false;
        this.menuHeader = menuHeader;
        commandList = new ArrayList<>();
        commandList.addAll(Arrays.asList(commands));
        if (addExitCMD) commandList.add(new ExitMenu(view, this));
    }
    public String buildMenu() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(menuHeader);
        for (int i = 0; i < commandList.size(); i++) {
            strBuilder.append(String.format("%d. %s\n", i+1, commandList.get(i).getDescription()));
        }
        return strBuilder.toString();
    }
    public void exec(int commandNumber) {
        commandList.get(commandNumber-1).exec();
    }
    public int size() {
        return commandList.size();
    }
    public boolean isActive() {
        return active;
    }
    public void setActive() {
        active = true;
    }
    public void unsetActive() {
        active = false;
    }
}
