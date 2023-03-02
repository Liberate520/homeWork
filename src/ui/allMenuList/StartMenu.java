package ui.allMenuList;

import java.util.ArrayList;
import ui.Console;
import ui.commands.Command;
import ui.commands.commandsStartMenu.CreateNewTree;
import ui.commands.commandsStartMenu.Exit;
import ui.commands.commandsStartMenu.LoadTree;

public class StartMenu implements MenuOptionable{
    private ArrayList<Command> commands;
    private Console console;

    public StartMenu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new CreateNewTree(console));
        commands.add(new LoadTree(console));
        commands.add(new Exit(console));
    }

    @Override
    public ArrayList<Command> getCommands() {
        return commands;
    }
}