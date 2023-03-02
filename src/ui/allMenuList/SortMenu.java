package ui.allMenuList;

import java.util.ArrayList;
import ui.Console;
import ui.commands.Command;
import ui.commands.commandsSortMenu.SortByName;
import ui.commands.commandsSortMenu.SortByYearOfBirth;

public class SortMenu implements MenuOptionable{
    private ArrayList<Command> commands;
    private Console console;

    public SortMenu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new SortByName(console));
        commands.add(new SortByYearOfBirth(console));
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}
