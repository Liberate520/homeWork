package ui.allMenuList;

import java.util.ArrayList;
import ui.Console;
import ui.commands.Command;
import ui.commands.commandsSecondaryMenu.ReturnMainMenu;
import ui.commands.commandsSecondaryMenu.ShowChildrens;
import ui.commands.commandsSecondaryMenu.ShowFather;
import ui.commands.commandsSecondaryMenu.ShowMother;

public class SecondaryMenu implements MenuOptionable{
    private ArrayList<Command> commands;
    private Console console;

    public SecondaryMenu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new ShowChildrens(console));
        commands.add(new ShowFather(console));
        commands.add(new ShowMother(console));
        commands.add(new ReturnMainMenu(console));
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}